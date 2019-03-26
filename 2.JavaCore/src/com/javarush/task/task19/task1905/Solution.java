package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        //Проверочный код для номера телефона

        /*Customer customer = new Customer() {
            @Override
            public String getCompanyName() {
                return null;
            }

            @Override
            public String getCountryName() {
                return null;
            }
        };
        Contact contact = new Contact() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };
        DataAdapter adapter = new DataAdapter(customer, contact);
        System.out.println(adapter.getDialString());*/
    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;

        DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countryCode = null;
            for (Map.Entry<String, String> entry : countries.entrySet()) {
                if (entry.getValue().equals(this.customer.getCountryName()))
                    countryCode = entry.getKey();
            }
            return countryCode;
        }

        @Override
        public String getCompany() {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] arr = this.contact.getName().split(", ", 2);
            return arr[1];
        }

        @Override
        public String getContactLastName() {
            String[] arr = this.contact.getName().split(", ", 2);
            return arr[0];
        }

        @Override
        public String getDialString() {
            //Регулярное выражение, что заменяет все символы "-", "(" и ")" на ничто (удаляет)
            String number = this.contact.getPhoneNumber().replaceAll("[-()]", "");
            return "callto://" + number;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}