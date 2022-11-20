package com.xxx.wxjsxy.web;

import com.xxx.wxjsxy.form.ActionForm;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class ActionServlet extends HttpServlet {
    private Map map1 = new HashMap();             //储存struts_config1不带表单
    private Map map2 = new HashMap();             //储存struts_config2带表单
    private static Map map3 = new HashMap();

    //最先执行的初始化
     @Override
    public void init() throws ServletException {
        System.out.println("init().......\n===========");
        //加载配置文件
        ResourceBundle sc1 = ResourceBundle.getBundle("struts_config1");
        ResourceBundle sc2 = ResourceBundle.getBundle("struts_config2");

        Enumeration<String> sc1Keys = sc1.getKeys();            //枚举对象
        Enumeration<String> sc2Keys = sc2.getKeys();
        insertMap(sc1Keys,sc1,map1);
        insertMap(sc2Keys,sc2,map2);
//        for (Object o : map1.keySet()) {
//            System.out.println("key1"+o);               //struts_config1 的 index.do
//        }
//        for (Object o : map2.keySet()) {
//            System.out.println("key2"+o);               //struts_config2 的 login.do
//        }
//         for (Object o : map3.keySet()) {
//             System.out.println(o);                     //login.do
//             System.out.println(map3.get(o));           //ActionMapping{path='login.do', actionFormName='com.xxx.wxjsxy.form.LoginForm', validateFlag='1', validateTarget='/WEB-INF/show.jsp', validateSpring='1', actionName='LoginAction', targe='/WEB-INF/show.jsp'}
//         }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet().......\n===========");
        doPost(request,response);           //直接执行post方法
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");          //设置编码格式
        System.out.println("doPost().......\n===========");
        String url = request.getRequestURL().toString();                //http://localhost:8080/BBS_System/index.do
        //System.out.println("url="+url);
        String target = url.substring(url.lastIndexOf("/") + 1);    //index.do
        //System.out.println("target="+target);
        ActionMapping actionMapping = (ActionMapping) map3.get(target); //ActionMapping{path='index.do', actionFormName='null', validateFlag='0', validateTarget='null', validateSpring='0', actionName='null', targe='/WEB-INF/show.jsp'}
        System.out.println("actionMapping="+actionMapping);
        String actionFormName = actionMapping.getActionFormName();      //null
        //System.out.println("actionFormName="+actionFormName);
        String actionName=actionMapping.getActionName();                //null
        //System.out.println("actionName:"+actionName);
        String valideFlag=actionMapping.getValidateFlag();              //0
        //System.out.println("valideFlag:"+valideFlag);
        ActionForm actionForm = null;

        //1. 先判断上传的的数据是否多段数据(只有是多段的数据，才是文件上传的)
         if ( ServletFileUpload.isMultipartContent(request) ) {
             String upload1 = request.getServletContext().getRealPath("/") + "imgs";
//             System.out.println(upload1);
//             String path = getServletContext().getRealPath("/upload");
//             System.out.println(path+"path");
             System.out.println("1");
             //创建 FileItemFactory 工厂实现类
             FileItemFactory fileItemFactory = new DiskFileItemFactory();
             // 2. 创建用于解析上传数据的工具类
             ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
             Class<?> c = null;
             Object instance = null;
             try {
                 c = Class.forName(actionFormName);
                 instance = c.newInstance();
             } catch (Exception e) {
                 e.printStackTrace();
             }
             System.out.println("c="+c);             //class com.xxx.wxjsxy.form.LoginForm

             System.out.println("instance="+instance);       //com.xxx.wxjsxy.form.LoginForm@763c82e3
             actionForm = (ActionForm) instance;
             System.out.println("actionForm="+actionForm);            //com.xxx.wxjsxy.form.LoginForm@763c82e3
             try {
                 // 3. 解析 上传的数据，得到每一个表单项 FiltItem
                 List<FileItem> list = servletFileUpload.parseRequest(request);
                 //循环判断，每一个表单项，是普通类型，还是上传的文件
                 for (FileItem fileItem : list) {
                     // 是普通表单项
                     System.out.println("2");
                     if ( fileItem.isFormField() ) {

                         String fieldName = fileItem.getFieldName();
                         String value = fileItem.getString("UTF-8");
                         System.out.println("表单项的name属性值 = " + fieldName);
                         System.out.println("表单项的value属性值 = " + value);
                         System.out.println("4");

                         String methodName="set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                         System.out.println("methodName====="+methodName);

                         Method[] methods=c.getDeclaredMethods();
                         for(int i=0;i<methods.length;i++){
                             Method m=methods[i];
                             //System.out.println("m===="+m.getName());
                             if(m.getName().equals(methodName)){
                                 m.invoke(instance,value);
                             }
                         }
                     }
                     else {
                             //是上传的文件
                             String name = fileItem.getFieldName();
                             String fieldName = fileItem.getName();

                             System.out.println("表单项的name属性值 = " + name);
                             System.out.println("上传的文件名 = " + fieldName);

                             String methodName="set"+name.substring(0,1).toUpperCase()+name.substring(1);
                             System.out.println("methodName====="+methodName);
                             String value = "imgs\\\\\\\\"+fieldName;
//                             System.out.println(value);
                             Method[] methods=c.getDeclaredMethods();
                             for(int i=0;i<methods.length;i++){
                                 Method m=methods[i];
                                 if(m.getName().equals(methodName)){
                                     m.invoke(instance,value);
                                 }
                             }

                             // 将数据写到指定的位置
//                             fileItem.write(new File( "D:\\JavaProject\\BBS_System\\web\\imgs\\"+fieldName));
                             fileItem.write(new File( upload1+"\\"+fieldName));
                         }
                     }
                 if(valideFlag.equals("1")) {
                     ActionErrors errors = actionForm.validateForm();
                     Map map = errors.getMap();
                     Collection values = map.values();
                     for (Object valueS : values) {
                         String valide = (String) valueS;
                         System.out.println(valide + "99999999");
                     }
                     String userErrey = (String) map.get("userErrey");
                     System.out.println(userErrey + "159753");
                     int errorsNum = map.size();
                     System.out.println(errorsNum);
                     if (errorsNum > 0) {
                         request.setAttribute("errors", errors);
                         request.setAttribute("form", actionForm);
                         request.getRequestDispatcher(actionMapping.getValidateTarget()).forward(request, response);
                         return;
                     }
                 }
             } catch (Exception e) {
                     e.printStackTrace();
                 }
                 if(valideFlag.equals("1")){
                     ServletContext context=this.getServletContext();
                     execute(actionForm,context,actionMapping,request,response);
                 }
             }
         else{
             System.out.println("3");

             if(actionFormName.equals("null")){
                 ServletContext context=this.getServletContext();
                 execute(actionForm,context,actionMapping,request,response);
             }else {
                 try {
                     Class<?> c = Class.forName(actionFormName);
                     System.out.println("c="+c);             //class com.xxx.wxjsxy.form.LoginForm
                     Object instance = c.newInstance();
                     System.out.println("instance="+instance);       //com.xxx.wxjsxy.form.LoginForm@763c82e3
                     actionForm = (ActionForm) instance;
                     System.out.println("actionForm="+actionForm);            //com.xxx.wxjsxy.form.LoginForm@763c82e3
                     Enumeration<String> parameterNames = request.getParameterNames();
                     System.out.println(parameterNames.hasMoreElements()+"papap");
                     while (parameterNames.hasMoreElements()){
                         String para = parameterNames.nextElement();        //user pw phone sex
                         String methodName="set"+para.substring(0,1).toUpperCase()+para.substring(1);
                         System.out.println("methodName====="+methodName);
                         String[] val=request.getParameterValues(para);
                         StringBuffer stringBuffer=new StringBuffer();
                         String lastval="";// user---zhangsan          zhangsan-
                         for (int i=0;i<val.length;i++){
                             stringBuffer.append(val[i]).append("-");
                         }
                         if(stringBuffer.toString().endsWith("-")){
                             lastval = stringBuffer.substring(0, stringBuffer.length() - 1).toString();
                             System.out.println("lastval=="+lastval);
                         }
                         Method[] methods=c.getDeclaredMethods();

                         for(int i=0;i<methods.length;i++){
                             Method m=methods[i];
                             //System.out.println("m===="+m.getName());
                             if(m.getName().equals(methodName)){
                                 m.invoke(instance,lastval);
//							if(val.length==1)
//							m.invoke(o, val[0]);
//							else
//							m.invoke(o, new Object[]{val});
                             }
                         }
                     }
                 }catch (Exception e){
                     e.printStackTrace();
                 }
                 if(valideFlag.equals("1")){
                     ActionErrors errors=actionForm.validateForm();
                     Map map=errors.getMap();
                     Collection values = map.values();
                     for (Object value : values) {
                         String valide = (String) value;
                         System.out.println(valide+"99999999");
                     }
                     String userErrey = (String) map.get("userErrey");
                     System.out.println(userErrey+"159753");
                     int errorsNum=map.size();
                     System.out.println(errorsNum);
                     if(errorsNum>0){
                         request.setAttribute("errors", errors);
                         request.setAttribute("form", actionForm);
                         request.getRequestDispatcher(actionMapping.getValidateTarget()).forward(request, response);
                         return;
                     }
                 }
             }

             if(valideFlag.equals("1")){
                 ServletContext context=this.getServletContext();
                 execute(actionForm,context,actionMapping,request,response);
             }
         }
    }

    public static void execute(ActionForm actionForm,ServletContext context,ActionMapping actionMapping,HttpServletRequest request,HttpServletResponse response){
        //System.out.println("context="+context.getContextPath());        // /BBS_System
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
        //System.out.println("webApplicationContext="+webApplicationContext.getApplicationName());    // /BBS_System
        //System.out.println("actionMapping.getPath()="+actionMapping.getPath());             //showRegister.do
        Object bean = webApplicationContext.getBean(actionMapping.getPath());
        Action action=(Action)bean;
        action.execute(actionForm, actionMapping, request, response);
    }

    public static void insertMap(Enumeration<String> keys, ResourceBundle sc, Map map){
        while (keys.hasMoreElements()){             //测试Enumeration枚举对象中是否还含有元素，如果返回true，则表示还含有至少一个的元素。
            String key = keys.nextElement();        //获取键
            String value = sc.getString(key);       //通过键获取值
            String mess[]=value.split("=");   //找到=把=去掉保留值
            map.put(key,new ActionMapping(key,mess[0],mess[1],mess[2],mess[3],mess[4],mess[5]));
            for (Object o : map.keySet()) {
                ActionMapping o1 = (ActionMapping) map.get(o);
                map3.put(o,o1);
            }
        }
    }
}
