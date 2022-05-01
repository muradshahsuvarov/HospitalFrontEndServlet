package DbEntities;

import java.io.IOException;

public abstract class DbEntity {


    public void PrintData() {}

    public Boolean DeleteData(String _key) { return false; }

    public void CreateTable() {}

    public Boolean AddRow(StringBuilder _row) throws IOException { return false; }

}
