package com.lbspak.view.ManagedBeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import oracle.adf.view.rich.component.rich.input.RichInputDate;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.joda.time.DurationFieldType;

public class ElectronicMediaActions {
    private HashMap columns;
    private RichInputDate dateFrom;
    private RichInputDate dateTo;

    public ElectronicMediaActions() {
        if (columns == null) {
            columns = new HashMap();
        }
    }

    public void setColumns(HashMap columns) { this.columns = columns;}

    public HashMap getColumns() {return columns;}

    public String showDays() {
        Date dateFrom = (Date)getDateFrom().getValue();
        Date dateTo = (Date)getDateTo().getValue();
        int dayNo = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateFrom);
        
        while (cal.getTime().before(dateTo)) {
            cal.add(Calendar.DATE, 1);
            dayNo = ((dayNo==0) ? cal.get(Calendar.DAY_OF_MONTH): (++dayNo));
            this.columns.put("Day "+dayNo, true);
        }
        
        
        
        return null;
    }

    public void setDateFrom(RichInputDate dateFrom) {this.dateFrom = dateFrom;}

    public RichInputDate getDateFrom() {return dateFrom;}

    public void setDateTo(RichInputDate dateTo) {this.dateTo = dateTo;}

    public RichInputDate getDateTo() {return dateTo;}
}
