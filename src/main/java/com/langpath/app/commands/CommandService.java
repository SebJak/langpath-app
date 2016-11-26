package com.langpath.app.commands;

public interface CommandService<T> {

    int command(T input);
}
