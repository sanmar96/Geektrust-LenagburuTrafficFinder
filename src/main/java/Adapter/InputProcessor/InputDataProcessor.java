package Adapter.InputProcessor;

import Exchanges.InputResponse;

import java.io.IOException;

public interface InputDataProcessor {

    public InputResponse execute(String txtFile) throws IOException;
}
