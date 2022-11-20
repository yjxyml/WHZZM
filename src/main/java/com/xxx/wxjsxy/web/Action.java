package com.xxx.wxjsxy.web;

import com.xxx.wxjsxy.form.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
    public abstract void execute(ActionForm form, ActionMapping mapping, HttpServletRequest request, HttpServletResponse response);
}
