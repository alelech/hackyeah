package pl.hackyeah.hackyeah.controlles.request;

import java.util.List;

public class ProcessFileRequest {

    private List<String> addressColumns;
    private long fileId;

    public List<String> getAddressColumns() {
        return addressColumns;
    }

    public void setAddressColumns(List<String> addressColumns) {
        this.addressColumns = addressColumns;
    }

}
