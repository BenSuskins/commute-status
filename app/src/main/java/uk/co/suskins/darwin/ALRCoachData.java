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
import org.ksoap2.serialization.AttributeInfo;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class ALRCoachData extends AttributeContainer implements KvmSerializable {

    public String coachClass;

    public ALRToiletAvailabilityType toilet;

    public Integer loading;

    public String number;

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

        if (inObj.hasAttribute("number")) {
            java.lang.Object j = inObj.getAttribute("number");
            if (j != null) {
                number = j.toString();
            }
        }

    }


    protected boolean loadProperty(PropertyInfo info, SoapObject soapObject, ALRExtendedSoapSerializationEnvelope __envelope) {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("coachClass")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.coachClass = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.coachClass = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("toilet")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.toilet = (ALRToiletAvailabilityType) __envelope.get(j, ALRToiletAvailabilityType.class, false);
            }
            return true;
        }
        if (info.name.equals("loading")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.loading = Integer.parseInt(j.toString());
                    }
                } else if (obj instanceof Integer) {
                    this.loading = (Integer) obj;
                }
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
            return this.coachClass != null ? this.coachClass : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 1) {
            return this.toilet != null ? this.toilet.getSimpleValue() : null;
        }
        if (propertyIndex == 2) {
            return this.loading != null ? this.loading : SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 3;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        if (propertyIndex == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "coachClass";
            info.namespace = "http://thalesgroup.com/RTTI/2017-10-01/ldb/types";
        }
        if (propertyIndex == 1) {
            info.type = org.ksoap2.serialization.SoapPrimitive.class;
            info.name = "toilet";
            info.namespace = "http://thalesgroup.com/RTTI/2017-10-01/ldb/types";
        }
        if (propertyIndex == 2) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "loading";
            info.namespace = "http://thalesgroup.com/RTTI/2017-10-01/ldb/types";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }


    @Override
    public int getAttributeCount() {
        return 1;
    }

    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        if (index == 0) {
            info.name = "number";
            info.namespace = "";
            if (this.number != null) {
                info.setValue(this.number);
            }

        }
    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }
}
