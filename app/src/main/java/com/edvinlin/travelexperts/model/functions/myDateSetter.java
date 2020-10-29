package com.edvinlin.travelexperts.model.functions;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class myDateSetter {
    private final Calendar calendar = Calendar.getInstance();
    public void setDate(EditText text, Context context)
    {
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
               calendar.set(Calendar.YEAR, year);
               calendar.set(Calendar.MONTH, month);
               calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
               updateLabel(text,calendar);
            }
        };
        text.setOnClickListener(v -> {
            new DatePickerDialog(context,date,calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
        });
    }
    public void updateLabel(EditText editText, Calendar myCalendar) {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.CANADA);
        editText.setText(sdf.format(myCalendar.getTime()));
    }
}
