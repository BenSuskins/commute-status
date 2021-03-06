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

public class ALRFormationData extends AttributeContainer implements KvmSerializable {

    public Integer avgLoading;

    public ALRArrayOfCoaches coaches;

    private transient java.lang.Object __source;


    public void loadFromSoap(java.lang.Object paramObj, ALRExtendedSoapSerializationEnvelope __envelope) {
        if (paramObj == null)
            return;
        AttributeContainer inObj = (AttributeContainer) paramObj;
        __source = inObj;

        if (inObj instanceof SoapObject) {
            SoapObject soapObject = (SoapObject) inObj;
            int size = soapObject.getPropertyCount();
            for (int i0 = 0; i0 < size; i0++) {
                PropertyInfo info = soapObject.getPropertyInfo(i0);
                if (!loadProperty(info, soapObject, __envelope)) {
                }
            }
        }


    }


    protected boolean loadProperty(PropertyInfo info, SoapObject soapObject, ALRExtendedSoapSerializationEnvelope __envelope) {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("avgLoading")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.avgLoading = Integer.parseInt(j.toString());
                    }
                } else if (obj instanceof Integer) {
                    this.avgLoading = (Integer) obj;
                }
            }
            return true;
        }
        if (info.name.equals("coaches")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.coaches = (ALRArrayOfCoaches) __envelope.get(j, ALRArrayOfCoaches.class, false);
            }
            return true;
        }
        return false;
    }

    public java.lang.Object getOriginalXmlSource() {
        return __source;
    }


    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if (propertyIndex == 0) {
            return this.avgLoading != null ? this.avgLoading : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 1) {
            return this.coaches != null ? this.coaches : SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 2;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        if (propertyIndex == 0) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "avgLoading";
            info.namespace = "http://thalesgroup.com/RTTI/2017-10-01/ldb/types";
        }
        if (propertyIndex == 1) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "coaches";
            info.namespace = "http://thalesgroup.com/RTTI/2017-10-01/ldb/types";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }


}
