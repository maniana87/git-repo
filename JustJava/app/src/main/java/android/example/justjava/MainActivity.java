/*
 * Важно: Убедитесь, что вы используете правильное имя пакета.
 * В этом примере используется имя пакета:
 * пакет com.образец.Android.justjava
 * Если вы получили ошибку при копировании этого кода в Android studio, обновите его, чтобы он соответствовал найденному имени пакета
 * в проекте AndroidManifest.XML-файл.
 */

package android.example.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/*
 * Это приложение отображает форму заказа на заказ кофе.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        displayMessage(createOrderSummery(price,quantity,view));
    }


    private String createOrderSummery(int price, int quantity, View view) {
        String message = "Имя: Алексей";
        message += "\nВзбитые сливки? " + onCheckBoxClicked(view);
        message += "\nКолличество: " + quantity;
        message += "\nЦена: " + price + " рублей";
        message += "\nСпасибо!";
        return message;
    }

    public boolean onCheckBoxClicked(View view){
        CheckBox checkBox = findViewById(R.id.check_box);
        boolean isCheckBox = checkBox.isChecked();
        return isCheckBox;
    }


    /*
     * Calculates the price of the order.
     *
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    // Метод кнопки +, которая добавляет + одну чашку кофе.
    public void increment(View view) {
        quantity += 1;
        displayQuantity(quantity);
    }

    // Метод кнопки -, которая убавляет на одну чашку кофе.
    public void decrement(View view) {
        quantity -= 1;
        displayQuantity(quantity);
    }

    /*
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /*
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}