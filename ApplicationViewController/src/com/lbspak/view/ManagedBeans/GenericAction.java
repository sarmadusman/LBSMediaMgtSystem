package com.lbspak.view.ManagedBeans;

import javax.el.ExpressionFactory;

import javax.el.ValueExpression;

import javax.faces.context.FacesContext;

public class GenericAction {
    public GenericAction() {
    }

    public String logout() {
        
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExpressionFactory expressionFactory = ctx.getApplication().getExpressionFactory();
        ValueExpression ve = expressionFactory.createValueExpression(ctx.getELContext(), "#{UserBean}", User.class);  
        User test = (User)ve.getValue(ctx.getELContext());  
        System.out.println("sdfds: "+test.get_username().getValue().toString());
        return null;
    }
}
