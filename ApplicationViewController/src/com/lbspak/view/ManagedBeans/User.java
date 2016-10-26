package com.lbspak.view.ManagedBeans;

import com.lbspak.model.appmodules.LBSAppModuleImpl;

import javax.faces.context.ExternalContext;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.util.ComponentReference;

public class User {
    private RichInputText _username;
    private RichInputText _password;
    private boolean hasLogin = false;

    public User() {
        super();
    }

    public void doLogin() {
        String username = this._username.getValue().toString();
        String password = this._password.getValue().toString();
        LBSAppModuleImpl am = (LBSAppModuleImpl)getAppModule();
        ViewObjectImpl usersVO = am.getVOFndUsers1();

        RowSetIterator rsi = usersVO.createRowSetIterator(null);
        if (rsi.getAllRowsInRange().length > 0) {
            Row row = rsi.getAllRowsInRange()[0];
            String _username = row.getAttribute("UserName").toString();
            String _password = row.getAttribute("Password").toString();
            if (_username.equals(username) && _password.equals(password)) {
                setHasLogin(true);
            }else{
                setHasLogin(false);
            }
        }else{
            setHasLogin(false);
        }

    }

    public void set_username(RichInputText _username) {
        this._username = _username;
    }

    public RichInputText get_username() {
        return _username;
    }

    public void set_password(RichInputText _password) {
        this._password = _password;
    }

    public RichInputText get_password() {
        return _password;
    }

    public boolean getHasLogin() {
        return this.hasLogin;
    }

    public void setHasLogin(boolean newBool) {
        this.hasLogin = newBool;
    }

    public static Object getAppModule() {
        return getDataControl("LBSAppModuleDataControl").getDataProvider();
    }

    public static DCDataControl getDataControl(String dataControl) {
        return getBindingContext().findDataControl(dataControl);
    }

    private static BindingContext getBindingContext() {
        return BindingContext.getCurrent();
    }

    public String logout() {
        setHasLogin(false);
        return null;
    }
}
