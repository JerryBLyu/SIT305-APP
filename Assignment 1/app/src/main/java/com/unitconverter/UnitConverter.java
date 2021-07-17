package com.unitconverter;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class UnitConverter {
    private String unitType;
    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    public UnitConverter(){
    }

    public void setUnitType(String unitType){
        this.unitType = unitType;
    }

    public Map<String, String> calculate(double inputVal) {
        Map<String, String> result = new LinkedHashMap<>();

        switch(unitType) {
            case "distances":
                result.put("Centimetre", convert(inputVal, 100, 0));
                result.put("Foot", convert(inputVal, 3.2808399, 0));
                result.put("Inch", convert(inputVal, 39.3700787, 0));
                break;
            case "temp":
                result.put("Fahrenheit", convert(inputVal, 1.8, 32));
                result.put("Kelvin", convert(inputVal, 1, 273.15));
                break;
            case "weights":
                result.put("Gram", convert(inputVal, 1000, 0));
                result.put("Ounce(Oz)", convert(inputVal, 35.2739619, 0));
                result.put("Pound(lb)", convert(inputVal, 2.20462262, 0));
                break;
        }
        return result;
    }

    private String convert(double inputVal, double v, double v2) {
        return decimalFormat.format(inputVal * v + v2);
    }
}
