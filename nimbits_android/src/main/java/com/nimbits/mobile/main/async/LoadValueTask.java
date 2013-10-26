/*
 * Copyright (c) 2013 Nimbits Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either expressed or implied.  See the License for the specific language governing permissions and limitations under the License.
 */

package com.nimbits.mobile.main.async;

import android.os.AsyncTask;
import android.util.Log;
import com.nimbits.client.model.entity.Entity;
import com.nimbits.client.model.value.Value;
import com.nimbits.mobile.application.SessionSingleton;
import com.nimbits.transaction.Transaction;
import com.nimbits.transaction.TransactionFactory;

import java.util.List;

/**
 * Author: Benjamin Sautner
 * Date: 1/13/13
 * Time: 8:57 AM
 */
public class LoadValueTask extends AsyncTask<Object, List<Value>, List<Value>> {

    public static final String TAG = "LoadValueTask";
    public LoadValueTaskListener mListener;
    private Transaction transactions = TransactionFactory.getInstance(SessionSingleton.getInstance().getServer(), SessionSingleton.getInstance().getEmail());

    private LoadValueTask() {

    }


    public interface LoadValueTaskListener {
        public void onSuccess(Value response);

    }

    public static LoadValueTask getInstance(final LoadValueTaskListener listener) {
        LoadValueTask instance = new LoadValueTask();

        instance.setListener(listener);
        return instance;

    }

    public void setListener(final LoadValueTaskListener mListener) {
        this.mListener = mListener;
    }


    @Override
    protected List<Value> doInBackground(final Object... objects) {
        List<Value> response;
        Entity e = (Entity) objects[0];

        Log.v(TAG, "getting value");

        response =transactions.getValue(e);

        Log.v(TAG, "got a value for " + e.getKey());
        Log.v(TAG, "got a value for " + response.isEmpty());

        return response;


    }

    @Override
    @SuppressWarnings("unchecked")
    protected void onPostExecute(final List<Value> response) {

        super.onPostExecute(response);
        if (!response.isEmpty()) {
            if (mListener != null) {
                mListener.onSuccess(response.get(0));
            }


        }

    }


}
 
  