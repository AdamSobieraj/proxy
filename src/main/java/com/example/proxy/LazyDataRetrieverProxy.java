package com.example.proxy;

import com.example.proxy.db.DbDataRetriever;
import com.example.proxy.db.PostgresDataRetriever;

public class LazyDataRetrieverProxy implements DbDataRetriever {

    private DbDataRetriever retriever;

    @Override
    public int getFirstValue() throws InterruptedException {
        if (retriever == null)
            retriever = new PostgresDataRetriever();
        return retriever.getFirstValue();
    }

    @Override
    public int getSecondValue() throws InterruptedException {
        if (retriever == null)
            retriever = new PostgresDataRetriever();
        return retriever.getSecondValue();
    }

    @Override
    public int getThirdValue() throws InterruptedException {
        if (retriever == null)
            retriever = new PostgresDataRetriever();
        return retriever.getThirdValue();
    }

}
