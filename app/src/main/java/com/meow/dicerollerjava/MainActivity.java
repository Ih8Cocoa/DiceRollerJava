package com.meow.dicerollerjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // (7) Typically, you would want to limit the number of times you call findViewById,
    // since it is an expensive operation, as the method will have to search
    // the complex view hierarchy multiple times.
    // The strat is to search the dice_image view only once (in onCreate()),
    // and store it in a class field.
    private ImageView diceImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // (1) Once you assign an ID for an element, the Android compiler will create a constant
        // reference to it, and store it in the "R" class. You can then use findViewById()
        // to get the reference of that view for your amusement
        Button rollButton = findViewById(R.id.roll_button);

        // (8) Initialize diceImage view ONLY ONCE
        diceImage = findViewById(R.id.dice_image);

        // (2) You can also set a button's on-click listener, so it will execute a certain action
        // when clicked
        rollButton.setOnClickListener(view -> {
            // (3) roll the dice
            rollDice();
        });

    }

    private void rollDice() {
        // (4) get random number from 1 to 6
        Random r = new Random();
        int randomInt = r.nextInt(6) + 1;
        int drawableResource = castToResource(randomInt);

        //(6) find the view with ID dice_image and update its image resource
        // ImageView diceImage = findViewById(R.id.dice_image)              (delete this line after (8));
        diceImage.setImageResource(drawableResource);
    }

    /**
     * convert the number to an integer representing the dice resource image
     * @param number The random integer
     * @return The integer that represents the random image
     */
    private int castToResource(final int number) {
        // (5) use a switch expression to select the dice, based on the number
        int rtn;
        switch (number) {
            case 1:
                rtn = R.drawable.dice_1;
                break;
            case 2:
                rtn = R.drawable.dice_2;
                break;
            case 3:
                rtn = R.drawable.dice_3;
                break;
            case 4:
                rtn = R.drawable.dice_4;
                break;
            case 5:
                rtn = R.drawable.dice_5;
                break;
            default:
                rtn = R.drawable.dice_6;
                break;
        }
        return rtn;
    }
}
