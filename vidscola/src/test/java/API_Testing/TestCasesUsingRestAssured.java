package API_Testing;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class TestCasesUsingRestAssured {

    @Test
    //As a carrier, I should be able to view a list of available shipments with all their details to be able to bid on them
    public void requestListAvailableShipmentsTest(){
        Response response = RestAssured.
                given().
                auth().preemptive().basic("Authorization", "hagar.gamala2@gmail.com").
                get("https://case-api.trella.app/marketplace");

        response.print();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
        List<Integer> shipments = response.jsonPath().getList("key");
        Assert.assertFalse(shipments.isEmpty(), "List of shipments is empty, but it shouldn't be");
        System.out.println("All the details for each shipment :");
        System.out.println(response.then().log().body());
        System.out.println("The Numbers of all shipments : " + shipments.size() + " Shipments");
    }

    @Test
    //As a carrier, I should be able to filter the shipments using longitude and latitude to view the shipments close to my location
    public void requestFilterShipmentsTest(){

        Response response = RestAssured.
                given().
                auth().preemptive().basic("Authorization", "hagar.gamala2@gmail.com").
                get("https://case-api.trella.app/marketplace?lng=30&lat=30");
        response.print();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
        List<Integer> filterShipments = response.jsonPath().getList("key");
        Assert.assertFalse(filterShipments.isEmpty(), "List of shipments is empty, but it shouldn't be");
        System.out.println("All the details for each shipment :");
        System.out.println(response.then().log().body());
        System.out.println("The Numbers of shipments close to my location : " + filterShipments.size() + " Shipments");
    }
}
