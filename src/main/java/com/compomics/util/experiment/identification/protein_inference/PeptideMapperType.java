package com.compomics.util.experiment.identification.protein_inference;

/**
 * Enum of the different peptide mappers implemented.
 *
 * @author Marc Vaudel
 * @author Dominik Kopczynski
 */
public enum PeptideMapperType {

    /**
     * The FM index.
     */
    fm_index(0, "FM-Index", "Full-text index in Minute space index stored in a wavelet tree."),
    /**
     * The protein tree.
     */
    tree(1, "Tree", "Protein fasta database index in the form of a tree using a database as back-end.");

    /**
     * The unique index of the peptide mapper.
     */
    public final int index;
    /**
     * The name of the peptide mapper.
     */
    public final String name;
    /**
     * The description of the peptide mapper.
     */
    public final String description;

    /**
     * Constructor.
     *
     * @param index a unique index
     * @param name the name to assign
     * @param description the description to use
     */
    private PeptideMapperType(int index, String name, String description) {
        this.index = index;
        this.name = name;
        this.description = description;
    }

    /**
     * Returns the different matching types as command line options description.
     *
     * @return the different matching types as command line options description
     */
    public static String getCommandLineOptions() {
        StringBuilder optionsStringBuilder = new StringBuilder();
        for (PeptideMapperType matchingType : values()) {
            if (optionsStringBuilder.length() != 0) {
                optionsStringBuilder.append(", ");
            }
            optionsStringBuilder.append(matchingType.index).append(": ").append(matchingType.description);
        }
        return optionsStringBuilder.toString();
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Returns the peptide mapper type corresponding to the given index.
     *
     * @param index the index of the peptide mapper type
     *
     * @return the peptide mapper type
     */
    public static PeptideMapperType getPeptideMapperType(int index) {
        for (PeptideMapperType mapperType : values()) {
            if (mapperType.index == index) {
                return mapperType;
            }
        }
        throw new IllegalArgumentException("No peptide mapper type found for index " + index + ".");
    }
}
