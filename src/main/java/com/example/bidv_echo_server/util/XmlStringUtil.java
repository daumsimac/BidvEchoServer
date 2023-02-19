package com.example.bidv_echo_server.util;

public class XmlStringUtil {

    public static String createValidXml(String arg){
        String str = removeProlog(removeN(removeBackSlash(removeDoubleQoute(arg))));
        return str;
    }
    public static String removeDoubleQoute(String arg){
        String str = arg.replaceAll("\"", "");
        return str;
    }

    public static String removeBackSlash(String arg){
        String str = arg.replaceAll("\\\\", "");
        return str;
    }

    public static String removeN(String arg){
        String str = arg.replaceAll(">n", ">");
        return str;
    }

    public static String removeProlog(String arg){
        String str = arg.substring(49, arg.length());;
        return str;
    }
}
