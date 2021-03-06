/*
 * Copyright (C) Lennart Martens
 * 
 * Contact: lennart.martens AT UGent.be (' AT ' to be replaced with '@')
 */

/*
 * Created by IntelliJ IDEA.
 * User: Lennart
 * Date: 24-dec-02
 * Time: 15:52:54
 */
package com.compomics.util.db;
import org.apache.log4j.Logger;

import com.compomics.util.db.components.*;

import java.util.Date;
import java.text.SimpleDateFormat;

/*
 * CVS information:
 *
 * $Revision: 1.4 $
 * $Date: 2007/07/06 09:41:53 $
 */

/**
 * This class represents an accessor class' sourcecode as generated by the DBAccessorGenerator
 * class.
 *
 * @author Lennart Martens
 */
public class DBAccessor {

    // Class specific log4j logger for DBAccessor instances.
    Logger logger = Logger.getLogger(DBAccessor.class);

    /**
     * The name for the generated class.
     */
    private String iName = null;

    /**
     * The package for the generated class.
     */
    private String iPackage = null;

    /**
     * The getters and setters for the generated class' variables.
     */
    private GettersAndSetters iGetSet = null;

    /**
     * The generated class' variables.
     */
    private InstanceVariables iVars = null;

    /**
     * The generated class' constructor.
     */
    private Constructors iConstr = null;

    /**
     * The generated code to implement deleteable.
     */
    private DeleteableCode iDeleteable = null;

    /**
     * The generated code to implement Retrieveable.
     */
    private RetrievableCode iRetrieveable = null;

    /**
     * The generated code to implement Updateable
     */
    private UpdateableCode iUpdateable = null;

    /**
     * The generated code to implement Persistable.
     */
    private PersistableCode iPersistable = null;

    /**
     * This constructor creates all code for the accessor,
     * based on the specified metadata.
     *
     * @param   aMeta   DBMetaData with the metadata to generate
     *                  the accessor for.
     * @param   aPackage    String with the packagename for the class ('null' if none is desired).
     * @param   debug   boolean to indicate whether output to stdout is necessary (or desired).
     */
    public DBAccessor(DBMetaData aMeta, String aPackage, boolean debug) {
        // The class name will be extracted here, the rest is up to the individual components.
        String name = aMeta.getTableName();
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        this.iName = name + "TableAccessor";
        iPackage = aPackage.trim();

        // Individual components.
        if(debug)logger.info("\nGenerating instance variables...");
        iVars = new InstanceVariables(aMeta);
        if(debug)logger.info("Variables done.\nGenerating constructors...");
        iConstr = new Constructors(aMeta);
        if(debug)logger.info("Constructors done.\nGenerating Getters and Setters...");
        iGetSet = new GettersAndSetters(aMeta);
        if(debug)logger.info("Getters and Setters done.\nGenerating Deleteable implementation...");
        iDeleteable = new DeleteableCode(aMeta);
        if(debug)logger.info("Deleteable implementation done.\nGenerating Retrievable implementation...");
        iRetrieveable = new RetrievableCode(aMeta);
        if(debug)logger.info("Retrievable implementation done.\nGenerating Updateable implementation...");
        iUpdateable = new UpdateableCode(aMeta);
        if(debug)logger.info("Updateable implementation done.\nGenerating Persistable implementation...");
        iPersistable = new PersistableCode(aMeta);
        if(debug)logger.info("Persistable implementation done.\n\nGeneration process complete!.");
    }

    /**
     * This method returns the generated code as a String.
     *
     * @return  String  with the generated code.
     */
    public String toString() {
        // Start with the class declaration.
        // Date and time of creation.
        Date date = new Date();
        SimpleDateFormat lsdDate = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat lsdTime = new SimpleDateFormat("HH:mm:ss");
        String lDate = lsdDate.format(date);
        String time = lsdTime.format(date);
        StringBuffer lsb = new StringBuffer(
                "/*\n * Created by the DBAccessor generator.\n * Programmer: Lennart Martens\n * Date: "
                + lDate + "\n * Time: " + time + "\n */\n");
        // Package (if any).
        if(iPackage != null && !iPackage.equals("")) {
            lsb.append("package " + iPackage + ";\n");
        }
        // Imports.
        lsb.append("\nimport java.sql.*;\n");
        lsb.append("import java.io.*;\n");
        lsb.append("import java.util.*;\n");
        lsb.append("import com.compomics.util.db.interfaces.*;\n");
        // CVS information.
        lsb.append("\n/*\n * CVS information:\n *\n * $Revision: 1.4 $\n * $Date: 2007/07/06 09:41:53 $\n */\n");
        // Class documentation.
        int location = iName.indexOf("Table");
        lsb.append("\n/**\n * This class is a generated accessor for the " + iName.substring(0, location)
                + " table.\n *\n * @author DBAccessor generator class (Lennart Martens).\n */\n");
        // Class name + extensions/interfaces.
        lsb.append("public class " + iName + " implements Deleteable, Retrievable, Updateable, Persistable {\n");

        // Class components.
        lsb.append(iVars.toString());
        lsb.append(iConstr.toString());
        lsb.append(iGetSet.toString());
        lsb.append(iDeleteable.toString());
        lsb.append(iRetrieveable.toString());
        lsb.append(iUpdateable.toString());
        lsb.append(iPersistable.toString());
        // Closing bracket.
        lsb.append("}");

        return lsb.toString();
    }
}
