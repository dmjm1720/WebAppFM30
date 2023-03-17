package com.dmjsistemas.util;

public class Configuracion {

    //**Windows**//
    private static final String pathImagenCorreo = "C:\\img\\marubeni-logo.png";
    private static final String pathPDF = "C:\\XMLFM30\\pdf\\";
    private static final String pathXML = "C:\\XMLFM30\\xml\\";
    private static final String conexDB = "jdbc:sqlserver://10.220.221.158\\SQLEXPRESS;databaseName=DBFM30";
    private static final String conexUser = "sa";
    private static final String conexPwd = "sa";
    
    
    
    //**Linux**//
//    private static final String pathImagenCorreo = "/home/dmjm/Documentos/XMLFM30/img/marubeni-logo.png";
//    private static final String pathPDF = "/home/dmjm/Documentos/XMLFM30/pdf/";
//    private static final String pathXML = "/home/dmjm/Documentos/XMLFM30/xml/";
//    private static final String conexDB = "jdbc:sqlserver://localhost;databaseName=DBFM30";
//    private static final String conexUser = "sa";
//    private static final String conexPwd = "Dev23DMJMS1t3m45";

    public static String getPathImagenCorreo() {
        return pathImagenCorreo;
    }

    public static String getPathPDF() {
        return pathPDF;
    }

    public static String getPathXML() {
        return pathXML;
    }

    public static String getConexDB() {
        return conexDB;
    }

    public static String getConexUser() {
        return conexUser;
    }

    public static String getConexPwd() {
        return conexPwd;
    }

}
