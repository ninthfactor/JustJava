package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {


    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Calculates the price of the order.
     *
    */
    private int calculatePrice(int coffeePrice, Boolean needWhipping,
                                                                Boolean needChocolate){

        int whippingPrice = 0;
        int chocolatePrice = 0;

        if (needWhipping)
            whippingPrice = 1;

        if (needChocolate)
            chocolatePrice =2;

        int price = quantity * (coffeePrice + whippingPrice + chocolatePrice);
        return price ;
    }

    /**
     * This method is called when the order button is clicked.
     */

    // Method to create a summary text when order button is clicked

    private String createOrderSummary(String nameOnScreen, int price, String toppingString, int quantity){
        return "Name:"+
                nameOnScreen+
                "\n"+
                toppingString+
                "Quantity:"+
                quantity+
                "\n"+
                "Total:"+
                price+
                "\nThank You!";

    }


    // Create topping text details to add to final order

    private String getToppingText(Boolean topping1, Boolean topping2){

        String toppingText = "";
        if (topping1)
                 toppingText = toppingText + "Whipping Cream: True\n";
        else
                 toppingText = toppingText + "Whipping Cream : False\n";

        if (topping2)
            toppingText = toppingText + "Chocolate: True\n";
        else
            toppingText = toppingText + "Chocolate : False\n";

        return  toppingText;

    }




    public void submitOrder(View view) {

        CheckBox topping1 = (CheckBox)findViewById(R.id.topping1);
        CheckBox topping2 = (CheckBox)findViewById(R.id.topping2);
        Boolean needWhipping = topping1.isChecked();
        Boolean needChocolate = topping2.isChecked();

        int priceOfCoffee = 5;

        int price = calculatePrice(priceOfCoffee, needWhipping,needChocolate );

     // Get name entered on screen

        EditText name = (EditText)findViewById(R.id.name_view);
        String nameOnScreen = name.getText().toString();

        String toppingText = getToppingText(needWhipping, needChocolate);
        String orderSummaryTextView = createOrderSummary(nameOnScreen,price, toppingText, quantity);
        displayMessage(orderSummaryTextView);
    }

    // call this method when the plus button is hit

    public void increment(View view){

        quantity = quantity + 1;
        displayQuantity(quantity);
        //displayPrice(quantity * 5);

    }

    // call this method when the minus button is hit

    public void decrement(View view){

        quantity = quantity - 1;
        displayQuantity(quantity);
        //displayPrice(quantity * 5);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}