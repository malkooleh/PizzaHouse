package ua.pizzeria.ws.client_ws;

import ua.pizzeria.ws.geoIPservice.GeoIP;
import ua.pizzeria.ws.geoIPservice.GeoIPService;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        // создаем ссылку на wsdl описание
        URL url = new URL("http://www.webservicex.net/geoipservice.asmx?WSDL");

        // Параметры следующего конструктора смотрим в самом первом теге WSDL описания - definitions
        // 1-ый аргумент смотрим в атрибуте targetNamespace
        // 2-ой аргумент смотрим в атрибуте name
        QName qname = new QName("http://www.webservicex.net/", "GeoIPService");

//        // Теперь мы можем дотянуться до тега service в wsdl описании,
//        Service service = GeoIPService.create(url, qname);
//        // а далее и до вложенного в него тега port, чтобы
//        // получить ссылку на удаленный от нас объект веб-сервиса
//        GeoIPService hello = service.getPort(GeoIPService.class);

        GeoIPService hello = new GeoIPService();
        // Ура! Теперь можно вызывать удаленный метод
        GeoIP geoIP = hello.getGeoIPServiceSoap().getGeoIPContext();
        System.out.println(geoIP.getCountryCode() + ", " + geoIP.getCountryName() + ", " + geoIP.getIP());
        System.out.println(geoIP.getReturnCodeDetails());
    }
}
