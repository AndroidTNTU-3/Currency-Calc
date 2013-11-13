package com.example.carrencycalculator;

import android.net.http.HttpResponseCache;
import android.os.AsyncTask;

public class CurrencyParserService extends AsyncTask <String, String, String>
{
    private static CurrencyParserService _instance;

    private CurrencyParserService()
    {

    }

    @Override
    protected String doInBackground(String... params) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);    //To change body of overridden methods use File | Settings | File Templates.
    }

    // singleton construction http://sourcemaking.com/design_patterns/singleton
    public static CurrencyParserService getInstance()
    {
        if (_instance != null)
        {
            //do nothing
        }
        else
        {
            _instance = new CurrencyParserService();
        }

        return  _instance;
    }
}
