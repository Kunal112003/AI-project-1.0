package com.example.ai_project_10;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;

import com.example.ai_project_10.ui.expenses.ExpensesFragment;




public class AddEditExpenseFragment extends Fragment {


    private static final String TAG = "AddExpenseFragment";

    private Button addExpenseButton;

    public AddEditExpenseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.pop_up_window_add_expenses, container, false);

        addExpenseButton = view.findViewById(R.id.add_expense_button);


        // Find the UI elements by their IDs
        EditText editTextAmount = view.findViewById(R.id.expenseAmount);
        DatePicker datePicker = view.findViewById(R.id.expense_date);
        // Find the Spinner for category (if you added it to the layout)
        EditText editTextName = view.findViewById(R.id.expenseName);

        // Set click listener on the "Save Expense" button
        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the values entered by the user
                double amount = Double.parseDouble(editTextAmount.getText().toString());
                // Retrieve the selected date from the DatePicker
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1; // Month is zero-indexed, so add 1
                int year = datePicker.getYear();
                // Create a formatted date string (you can choose the format you prefer)
                String date = String.format("%02d/%02d/%04d", month, day, year);

                // Get the selected category from the Spinner (if you added it to the layout)
                String name = editTextName.getText().toString();



                //bundle
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putDouble("amount", amount);
                bundle.putString("date", date);
                bundle.putString("category", "111");

                // navigate to the ExpensesFragment
                Fragment fragment = new ExpensesFragment();
                NavHostFragment.findNavController(fragment).navigate(R.id.action_add_expense_fragment_to_nav_expenses, bundle);


            }
        });



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        // Find the UI elements by their IDs
        EditText editTextAmount = view.findViewById(R.id.expenseAmount);
        DatePicker datePicker = view.findViewById(R.id.expense_date);
        // Find the Spinner for category (if you added it to the layout)
        EditText editTextName = view.findViewById(R.id.expenseName);
        Button buttonSaveExpense = view.findViewById(R.id.addExpenseButton);

        // Set click listener on the "Save Expense" button
        buttonSaveExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the values entered by the user
                double amount = Double.parseDouble(editTextAmount.getText().toString());
                   // Get the date from the DatePicker
                long date = datePicker.getCalendarView().getDate();
                // Get the selected category from the Spinner (if you added it to the layout)
                String name = editTextName.getText().toString();



                //bundle
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putDouble("amount", amount);
                bundle.putLong("date", date);
                bundle.putString("category", "111");

                // navigate to the ExpensesFragment
                Fragment fragment = new ExpensesFragment();
                NavHostFragment.findNavController(fragment).navigate(R.id.action_add_expense_fragment_to_nav_expenses, bundle);


            }
        });
    }




}
