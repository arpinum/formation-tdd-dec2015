package mocks;

import es.EntreeStandard;

public class StubEntreeStandard implements EntreeStandard {
    public StubEntreeStandard(String dateSaisie) {
        this.dateSaisie = dateSaisie;
    }

    @Override
    public String lis() {
        return dateSaisie;
    }

    private String dateSaisie;
}
