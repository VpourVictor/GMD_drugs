package telecom.projet.model;

import java.util.ArrayList;

public class Drug {
    private String name;
    private String database_code;
    private String drugbank_id;

    private String database;


    public Drug(String name, String database_code, String drugbank_id, String database) {
        this.name = name;
        this.database_code = database_code;
        this.drugbank_id = drugbank_id;
        this.database = database;
    }

    public Drug(String database_code) {
        this.database_code = database_code;
        this.name = "";
        this.drugbank_id = "";
        this.database = "";
    }

    public Drug() {
        this.name = "";
        this.database_code = "";
        this.drugbank_id = "";
        this.database = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatabase_code() {
        return database_code;
    }

    public void setDatabase_code(String database_code) {
        this.database_code = database_code;
    }

    public String getDrugbank_id() {
        return drugbank_id;
    }

    public void setDrugbank_id(String drugbank_id) {
        this.drugbank_id = drugbank_id;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "name='" + name + '\'' +
                ", database_code='" + database_code + '\'' +
                ", drugbank_id='" + drugbank_id + '\'' +
                ", database='" + database + '\'' +
                '}';
    }
}
