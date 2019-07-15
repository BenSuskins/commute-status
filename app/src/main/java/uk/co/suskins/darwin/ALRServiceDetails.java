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

public class ALRServiceDetails extends ALRBaseServiceDetails implements KvmSerializable {

    public ALRArrayOfAdhocAlert adhocAlerts;

    public ALRFormationData formation;

    public ALRArrayOfArrayOfCallingPoints_1 previousCallingPoints;

    public ALRArrayOfArrayOfCallingPoints_1 subsequentCallingPoints;


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
        if (info.name.equals("adhocAlerts")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.adhocAlerts = (ALRArrayOfAdhocAlert) __envelope.get(j, ALRArrayOfAdhocAlert.class, false);
            }
            return true;
        }
        if (info.name.equals("formation")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.formation = (ALRFormationData) __envelope.get(j, ALRFormationData.class, false);
            }
            return true;
        }
        if (info.name.equals("previousCallingPoints")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.previousCallingPoints = (ALRArrayOfArrayOfCallingPoints_1) __envelope.get(j, ALRArrayOfArrayOfCallingPoints_1.class, false);
            }
            return true;
        }
        if (info.name.equals("subsequentCallingPoints")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.subsequentCallingPoints = (ALRArrayOfArrayOfCallingPoints_1) __envelope.get(j, ALRArrayOfArrayOfCallingPoints_1.class, false);
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
            return this.adhocAlerts != null ? this.adhocAlerts : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == count + 1) {
            return this.formation != null ? this.formation : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == count + 2) {
            return this.previousCallingPoints != null ? this.previousCallingPoints : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == count + 3) {
            return this.subsequentCallingPoints != null ? this.subsequentCallingPoints : SoapPrimitive.NullSkip;
        }
        return super.getProperty(propertyIndex);
    }


    @Override
    public int getPropertyCount() {
        return super.getPropertyCount() + 4;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        int count = super.getPropertyCount();
        if (propertyIndex == count + 0) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "adhocAlerts";
            info.namespace = "http://thalesgroup.com/RTTI/2017-10-01/ldb/types";
        }
        if (propertyIndex == count + 1) {
            info.type = ALRFormationData.class;
            info.name = "formation";
            info.namespace = "http://thalesgroup.com/RTTI/2017-10-01/ldb/types";
        }
        if (propertyIndex == count + 2) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "previousCallingPoints";
            info.namespace = "http://thalesgroup.com/RTTI/2017-10-01/ldb/types";
        }
        if (propertyIndex == count + 3) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "subsequentCallingPoints";
            info.namespace = "http://thalesgroup.com/RTTI/2017-10-01/ldb/types";
        }
        super.getPropertyInfo(propertyIndex, arg1, info);
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }


}
