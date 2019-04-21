package com.sample.mockito.mockitodemo;

public class BussinessServiceImpl
{
    DataService dataService;


    public BussinessServiceImpl( DataService dataService )
    {
        this.dataService = dataService;
    }


    int findTheGreatestFromAllData(){
        int data[] = dataService.retrieveAllData();
        return data[0];


    }


}

interface DataService {
    int []retrieveAllData();

}
