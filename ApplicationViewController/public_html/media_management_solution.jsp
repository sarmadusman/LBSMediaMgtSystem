<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
  <af:document id="d1">
    <af:form id="f1">
      <af:pageTemplate viewId="/mainTemplate.jspx" id="pt1">
        <f:facet name="main_content">
          <af:group id="g1">
            <af:panelGroupLayout id="pgl1" layout="vertical" halign="center">
              <af:region value="#{bindings.tfuserlogin1.regionModel}" id="r1"/>
            </af:panelGroupLayout>
          </af:group>
        </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>