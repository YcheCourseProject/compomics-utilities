package com.compomics.util.experiment.identification.psm_scoring;

/**
 * Enum listing the PSM scores implemented in compomics utilities.
 *
 * @author Marc Vaudel
 */
public enum PsmScore {

    /**
     * The native score of the search engine.
     */
    native_score(-1, "Native", false, "The algorithm native score"),
    /**
     * The precursor accuracy.
     */
    precursor_accuracy(0, "Precursor accuracy", false, "Precursor accuracy score"),
    /**
     * Hyperscore as variation of the score implemented in X!Tandem www.thegpm.org/tandem.
     * See com.compomics.util.experiment.identification.psm_scoring.psm_scores.HyperScore for details.
     */
    hyperScore(1, "Hyperscore", true, "Hyperscore as variation of the score implemented in X!Tandem."),
    /**
     * The m/z fidelity score as adapted from the DirecTag paper
     * (http://www.ncbi.nlm.nih.gov/pubmed/18630943).
     */
    ms2_mz_fidelity(2, "Fragment ion mz fildelity", false, "Fragment ion m/z fidelity score"),
    /**
     * The m/z fidelity score as adapted from the DirecTag paper
     * (http://www.ncbi.nlm.nih.gov/pubmed/18630943) per amino acid.
     */
    aa_ms2_mz_fidelity(3, "AA fragment ion mz fildelity", false, "Fragment ion m/z fidelity score per amino acid"),
    /**
     * The intensity sub-score as adapted from the DirecTag paper
     * (http://www.ncbi.nlm.nih.gov/pubmed/18630943).
     */
    intensity(4, "Intensity", true, "Intensity score"),
    /**
     * The intensity sub-score as adapted from the DirecTag paper
     * (http://www.ncbi.nlm.nih.gov/pubmed/18630943) per amino acid.
     */
    aa_intensity(5, "AA intensity", false, "Intensity score per amino acid"),
    /**
     * The complementarity score as adapted from the DirecTag paper
     * (http://www.ncbi.nlm.nih.gov/pubmed/18630943).
     */
    complementarity(6, "Complementarity", true, "Ion complementarity score");

    /**
     * The index of the score of interest.
     */
    public final Integer index;
    /**
     * The name of the score.
     */
    public final String name;
    /**
     * Indicates whether the score increases with the quality of the match.
     */
    public final boolean increasing;
    /**
     * Short description of the score.
     */
    public final String description;

    /**
     * Constructor.
     *
     * @param index the index of the score
     * @param name the name of the score
     * @param increasing whether the score increases with the quality of the
     * match
     * @param description short description of the score
     */
    private PsmScore(int index, String name, boolean increasing, String description) {
        this.index = index;
        this.name = name;
        this.increasing = increasing;
        this.description = description;
    }

    /**
     * Returns the PSM score of the given index. Null if not found.
     *
     * @param scoreIndex the index of the desired score
     * @return the score of given index
     */
    public static PsmScore getScore(int scoreIndex) {
        for (PsmScore psmScore : values()) {
            if (psmScore.index == scoreIndex) {
                return psmScore;
            }
        }
        return null;
    }

    /**
     * Returns the PSM score of the given name. Null if not found.
     *
     * @param scoreName the name of the desired score
     *
     * @return the score of given name
     */
    public static PsmScore getScore(String scoreName) {
        for (PsmScore psmScore : values()) {
            if (psmScore.name.equals(scoreName)) {
                return psmScore;
            }
        }
        return null;
    }
}
