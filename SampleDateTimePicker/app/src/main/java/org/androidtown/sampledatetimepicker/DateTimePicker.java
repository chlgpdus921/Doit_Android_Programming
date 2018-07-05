package org.androidtown.sampledatetimepicker;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;
import java.util.jar.Attributes;

public class DateTimePicker extends LinearLayout {
    public static interface OnDateTimeChangedListener {
        void onDateTimeChanged(DateTimePicker view, int year, int monthOfYear, int dayOfYear, int hourOfDay, int minute);
    }

    private OnDateTimeChangedListener listener;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private CheckBox enableTimeCheckBox;
    int curYear;
    int curMonth;
    int curDay;
    int curHour;
    int curMinute;

    public int getYear(){
        return curYear;
    }
    public void setYear(int curYear){
        this.curYear = curYear;
    }
    public int getMonth(){
        return curMonth;
    }
    public void setMonth(int curMonth){
        this.curMonth = curMonth;
    }
    public int getDayOfDay(){
        return curDay;
    }
    public void setDayOfDay(int curDay){
        this.curDay = curDay;
    }
    public int getCurrentHour(){
        return curHour;
    }
    public void setCurrentHour(int curHour){
        this.curHour = curHour;
    }
    public int getCurrentMinute(){
        return curMinute;
    }
    public void setCurrentMinute(int curMinute){
        this.curMinute  = curMinute;
    }
    public DateTimePicker(Context context) {
        super(context);
        init(context);
    }

    public DateTimePicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.picker, this, true);

        Calendar calendar = Calendar.getInstance();
        final int curYear = calendar.get(Calendar.YEAR);
        final int curMonth = calendar.get(Calendar.MONTH);
        final int curDay = calendar.get(Calendar.DAY_OF_MONTH);
        final int curHour = calendar.get(Calendar.HOUR_OF_DAY);
        final int curMinute = calendar.get(Calendar.MINUTE);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        datePicker.init(curYear, curMonth, curDay, new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                if (listener != null) {
                    listener.onDateTimeChanged(DateTimePicker.this, year, monthOfYear, dayOfMonth, timePicker.getCurrentHour(),
                            timePicker.getCurrentMinute());
                }
            }
        });

        enableTimeCheckBox = (CheckBox) findViewById(R.id.enableTimeCheckBox);
        enableTimeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                timePicker.setEnabled(isChecked);
                timePicker.setVisibility((enableTimeCheckBox).isChecked() ? View.VISIBLE : View.INVISIBLE);
            }
        });

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if (listener != null) {
                    listener.onDateTimeChanged(DateTimePicker.this, datePicker.getYear(), datePicker.getMonth(),
                            datePicker.getDayOfMonth(), hourOfDay, minute);
                }
            }
        });
        timePicker.setCurrentHour(curHour);

        timePicker.setEnabled(enableTimeCheckBox.isChecked());timePicker.setCurrentMinute(curMinute);
        timePicker.setVisibility((enableTimeCheckBox.isChecked()) ? View.VISIBLE : View.INVISIBLE);
    }

    public void setOnDateTimeChangedListener(OnDateTimeChangedListener dateTimeListener) {
        this.listener = dateTimeListener;
    }

    public void updateDateTime(int year, int monthOfYear, int dayOfMonth, int currentHour, int currentMinute) {
        datePicker.updateDate(year, monthOfYear, dayOfMonth);
        timePicker.setCurrentHour(currentHour);
        timePicker.setCurrentMinute(currentMinute);
    }
}
