package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        //Проверка номера телефона
        IncomeData incomeData = new IncomeData() {
            @Override
            public String getCountryCode() {
                return null;
            }

            @Override
            public String getCompany() {
                return null;
            }

            @Override
            public String getContactFirstName() {
                return null;
            }

            @Override
            public String getContactLastName() {
                return null;
            }

            @Override
            public int getCountryPhoneCode() {
                return 38;
            }

            @Override
            public int getPhoneNumber() {
                return 501234567;
            }
        };

        IncomeDataAdapter adapter = new IncomeDataAdapter(incomeData);
        System.out.println(adapter.getPhoneNumber());

    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(this.data.getCountryCode());
        }

        @Override
        public String getName() {
            return this.data.getContactLastName() + ", " + this.data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String number = "0000000000" + this.data.getPhoneNumber();
            String trueNumber = number.substring(number.length()-10);
            return "+" + this.data.getCountryPhoneCode() + "(" +
                    trueNumber.substring(0, 3) + ")" + trueNumber.substring(3, 6) +
                    "-" + trueNumber.substring(6, 8) + "-" + trueNumber.substring(8);
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}