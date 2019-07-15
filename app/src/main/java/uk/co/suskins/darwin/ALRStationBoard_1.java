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
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class ALRStationBoard_1 extends ALRBaseStationBoard implements KvmSerializable {

    public ALRArrayOfServiceItems_1 trainServices;

    public ALRArrayOfServiceItems_1 busServices;

    public ALRArrayOfServiceItems_1 ferryServices;


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
        if (info.name.equals("trainServices")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.trainServices = (ALRArrayOfServiceItems_1) __envelope.get(j, ALRArrayOfServiceItems_1.class, false);
            }
            return true;
        }
        if (info.name.equals("busServices")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.busServices = (ALRArrayOfServiceItems_1) __envelope.get(j, ALRArrayOfServiceItems_1.class, false);
            }
            return true;
        }
        if (info.name.equals("ferryServices")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.ferryServices = (ALRArrayOfServiceItems_1) __envelope.get(j, ALRArrayOfServiceItems_1.class, false);
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
            return this.trainServices != null ? this.trainServices : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == count + 1) {
            return this.busServices != null ? this.busServices : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == count + 2) {
            return this.ferryServices != null ? this.ferryServices : SoapPrimitive.NullSkip;
        }
        return super.getProperty(propertyIndex);
    }


    @Override
    public int getPropertyCount() {
        return super.getPropertyCount() + 3;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        int count = super.getPropertyCount();
        if (propertyIndex == count + 0) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "trainServices";
            info.namespace = "http://thalesgroup.com/RTTI/2016-02-16/ldb/types";
        }
        if (propertyIndex == count + 1) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "busServices";
            info.namespace = "http://thalesgroup.com/RTTI/2016-02-16/ldb/types";
        }
        if (propertyIndex == count + 2) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "ferryServices";
            info.namespace = "http://thalesgroup.com/RTTI/2016-02-16/ldb/types";
        }
        super.getPropertyInfo(propertyIndex, arg1, info);
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }


}
