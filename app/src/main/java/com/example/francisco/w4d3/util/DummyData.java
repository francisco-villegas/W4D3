package com.example.francisco.w4d3.util;

import com.example.francisco.w4d3.model.Dishes;

import java.util.ArrayList;

/**
 * Created by FRANCISCO on 24/08/2017.
 */

public class DummyData {

    public static ArrayList<Dishes> getDummyData(){
        ArrayList<Dishes> dummy_data = new ArrayList<>();

        dummy_data.add(new Dishes(
                "Chaska",
                "Aguascalientes",
                "Mexican",
                "https://img.buzzfeed.com/buzzfeed-static/static/2015-06/22/12/enhanced/webdr15/original-7960-1434991383-3.jpg?downsize=715:*&output-format=auto&output-quality=auto",
                "The chaska (or chasca) is a typical dish of this state and consists of boiled corn, cooked with butter dipped in mayonnaise, lemon, cheese and chile." +
                        "Elsewhere it is known as esquites."
        ));

        dummy_data.add(new Dishes(
                "Seafood toast",
                "Baja California",
                "Mexican",
                "https://img.buzzfeed.com/buzzfeed-static/static/2015-06/22/12/enhanced/webdr09/original-22451-1434991549-3.jpg?downsize=715:*&output-format=auto&output-quality=auto",
                "Ensenada seafood toasts (in particular the street food stall \"La Guerrerense\") are recognized worldwide." +
                        "The hedgehog with pismo clam is a winner."
        ));

        dummy_data.add(new Dishes(
                "Locust",
                "Baja California Sur",
                "Mexican",
                "https://img.buzzfeed.com/buzzfeed-static/static/2015-06/19/14/enhanced/webdr12/original-30330-1434740136-4.jpg?downsize=715:*&output-format=auto&output-quality=auto",
                "Living surrounded by sea, it is no surprise that lobster is one of the most delightfully representative dishes of this state."
        ));


        dummy_data.add(new Dishes(
                "Cazón bread",
                "Campeche",
                "Mexican",
                "https://img.buzzfeed.com/buzzfeed-static/static/2015-06/22/12/enhanced/webdr06/original-10076-1434991905-11.jpg?downsize=715:*&output-format=auto&output-quality=auto",
                "The bread of cazón is created with fresh tortillas, beans and an exquisite sauce of casserole stew."
        ));

        dummy_data.add(new Dishes(
                "Chipilín",
                "Chiapas",
                "Mexican",
                "https://img.buzzfeed.com/buzzfeed-static/static/2015-06/22/13/enhanced/webdr10/original-11264-1434995930-5.jpg?downsize=715:*&output-format=auto&output-quality=auto",
                "The chipilín is a vegetable typical of the southeast that accompanies a great amount of chiapanecos dishes. This chipilin tamal will accompany your fantasies the rest of your days."
        ));

        dummy_data.add(new Dishes(
                "Roasted meat",
                "Coahuila",
                "Mexican",
                "https://img.buzzfeed.com/buzzfeed-static/static/2015-06/22/12/enhanced/webdr10/original-31016-1434992183-25.jpg?downsize=715:*&output-format=auto&output-quality=auto",
                "A perfect barbecue to enjoy a good meal typical of Coahuila. In taco or cut. Yum!"
        ));

        dummy_data.add(new Dishes(
                "Sopes",
                "Colima",
                "Mexican",
                "https://img.buzzfeed.com/buzzfeed-static/static/2015-06/22/14/enhanced/webdr02/original-1419-1434998018-3.jpg?downsize=715:*&output-format=auto&output-quality=auto",
                "In Colima they know how to eat, and their appetites prove it. Sopes or sopitos, which do you like more?"
        ));

        dummy_data.add(new Dishes(
                "Fried pork chops",
                "Michoacán",
                "Mexican",
                "https://img.buzzfeed.com/buzzfeed-static/static/2015-06/22/13/enhanced/webdr06/original-16219-1434993279-3.jpg?downsize=715:*&output-format=auto&output-quality=auto",
                "Fried pork chops with lemon, sauce, onion, cilantro and tortilla. Venture to try the nana, the buche and the corito."
        ));

        dummy_data.add(new Dishes(
                "Cecina",
                "Morelos",
                "Mexican",
                "https://img.buzzfeed.com/buzzfeed-static/static/2015-06/22/12/enhanced/webdr01/original-16081-1434990085-11.jpg?downsize=715:*&output-format=auto&output-quality=auto",
                "A Yecapixtla cecina is ideal for curing any hungry belly or broken heart. Introduce yourself."
        ));

        dummy_data.add(new Dishes(
                "Zarandeado fish",
                "Nayarit",
                "Mexican",
                "https://img.buzzfeed.com/buzzfeed-static/static/2015-06/22/13/enhanced/webdr06/original-15655-1434993458-3.jpg?downsize=715:*&output-format=auto&output-quality=auto",
                "A fish well shaken to give flavor to your life."
        ));

        return dummy_data;
    }
}
