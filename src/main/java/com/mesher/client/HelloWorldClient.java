package com.mesher.client;

import com.mesher.myproxy.myProxySelector;
import com.mesher.ws.HelloWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import java.net.ProxySelector;
import java.net.URL;

public class HelloWorldClient {
    public static void main(String[] args) throws Exception {
        String mesherName = "mesher";

        ProxySelector.setDefault(new myProxySelector());
//
        URL url = new URL(" http://"+mesherName+"/ws/hello?wsdl");
        QName qname = new QName("http://ws.mesher.com/", "HelloWorldImplService");

        Service service = Service.create(url, qname);
        HelloWorld hello = service.getPort(HelloWorld.class);

        System.out.println(hello.helloWorld("mesher"));
    }
}
