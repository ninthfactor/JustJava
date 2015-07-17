package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {


    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity, int pricePerCoffee) {
        int price = quantity * pricePerCoffee;
        return price ;
    }

    /**
     * This method is called when the order button is clicked.
     */

    // Method to create a summary text when order button is clicked

    private String createOrderSummary(int price, String toppingString, int quantity){
        return "Name: Varun\n"+toppingString+"Quantity:"+quantity+"\n"+"Total:"+price+  "\nThank You!";

    }


    // Create topping text details to add to final order

    private String getToppingText(View view){
        CheckBox topping1 = (CheckBox)findViewById(R.id.topping1);
        CheckBox topping2 = (CheckBox)findViewById(R.id.topping2);
        String toppingText = "";
        if (topping1.isChecked())
                 toppingText = toppingText + "Whipping Cream: True\n";
        else
                 toppingText = toppingText + "Whipping Cream : False\n";

        if (topping2.isChecked())
            toppingText = toppingText + "Chocolate: True\n";
        else
            toppingText = toppingText + "Chocolate : False\n";

        return  toppingText;

    }




    public void submitOrder(View view) {

     //   display(quantity);
     //   displayPrice(quantity * 5);

        int price = calculatePrice(quantity, 5 );
        String toppingText = getToppingText(view);
        String orderSummaryTextView = createOrderSummary(price, toppingText, quantity);
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