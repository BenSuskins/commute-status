package uk.co.suskins.darwin;
//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.6.0.0
//
// Created by Quasar Development 
//
//---------------------------------------------------


import org.ksoap2.serialization.AttributeContainer;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.util.Hashtable;

public class ALRDeparturesBoard_2 extends ALRBaseStationBoard implements KvmSerializable {

    public ALRArrayOfDepartureItems_2 departures = new ALRArrayOfDepartureItems_2();


    @Override
    public void loadFromSoap(java.lang.Object paramObj, ALRExtendedSoapSerializationEnvelope __envelope) {
        if (paramObj == null)
            return;
        AttributeContainer inObj = (AttributeContainer) paramObj;
        super.loadFromSoap(paramObj, __envelope);


    }

    @Override
    protected boolean loadProperty(PropertyInfo info, SoapObject soapObject, ALRExtendedSoapSerializationEnvelope __envelope) {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("departures")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.departures = (ALRArrayOfDepartureItems_2) __envelope.get(j, ALRArrayOfDepartureItems_2.class, false);
            }
            return true;
        }
        return super.loadProperty(info, soapObject, __envelope);
    }


    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        int count = super.getPropertyCount();
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if (propertyIndex == count + 0) {
            return departures;
        }
        return super.getProperty(propertyIndex);
    }


    @Override
    public int getPropertyCount() {
        return super.getPropertyCount() + 1;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        int count = super.getPropertyCount();
        if (propertyIndex == count + 0) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "departures";
            info.namespace = "http://thalesgroup.com/RTTI/2017-10-01/ldb/types";
        }
        super.getPropertyInfo(propertyIndex, arg1, info);
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }


}
