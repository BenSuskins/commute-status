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
import java.util.Vector;


public class ALRArrayOfCoaches extends Vector<ALRCoachData> implements KvmSerializable {
    private transient java.lang.Object __source;

    public void loadFromSoap(java.lang.Object inObj, ALRExtendedSoapSerializationEnvelope __envelope) {
        if (inObj == null)
            return;
        __source = inObj;
        SoapObject soapObject = (SoapObject) inObj;
        int size = soapObject.getPropertyCount();
        for (int i0 = 0; i0 < size; i0++) {
            java.lang.Object obj = soapObject.getProperty(i0);
            if (obj != null && obj instanceof AttributeContainer) {
                AttributeContainer j = (AttributeContainer) soapObject.getProperty(i0);
                ALRCoachData j1 = (ALRCoachData) __envelope.get(j, ALRCoachData.class, false);
                add(j1);
            }
        }
    }

    public java.lang.Object getSourceObject() {
        return __source;
    }

    @Override
    public java.lang.Object getProperty(int arg0) {
        return this.get(arg0) != null ? this.get(arg0) : SoapPrimitive.NullNilElement;
    }

    @Override
    public int getPropertyCount() {
        return this.size();
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        info.name = "coach";
        info.type = ALRCoachData.class;
        info.namespace = "http://thalesgroup.com/RTTI/2017-10-01/ldb/types";
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }


}