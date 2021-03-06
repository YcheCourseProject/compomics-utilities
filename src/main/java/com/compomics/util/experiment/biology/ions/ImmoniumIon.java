package com.compomics.util.experiment.biology.ions;

import com.compomics.util.experiment.biology.AminoAcid;
import com.compomics.util.experiment.biology.Atom;
import com.compomics.util.experiment.biology.Ion;
import com.compomics.util.experiment.biology.NeutralLoss;
import com.compomics.util.pride.CvTerm;
import java.util.ArrayList;

/**
 * Represents an immonium ion.
 *
 * @author Marc Vaudel
 */
public class ImmoniumIon extends Ion {

    /**
     * Serial number for backward compatibility.
     */
    static final long serialVersionUID = -3403620196563864756L;
    /**
     * Subtype int for an alanine immonium ion.
     */
    public static final int ALANINE = 0;
    /**
     * Subtype int for an arginine immonium ion.
     */
    public static final int ARGININE = 1;
    /**
     * Subtype int for an asparagine immonium ion.
     */
    public static final int ASPARAGINE = 2;
    /**
     * Subtype int for an aspartic acid immonium ion.
     */
    public static final int ASPARTIC_ACID = 3;
    /**
     * Subtype int for a cysteine immonium ion.
     */
    public static final int CYSTEINE = 4;
    /**
     * Subtype int for a glutamic acid immonium ion.
     */
    public static final int GLUTAMIC_ACID = 5;
    /**
     * Subtype int for a glutamine immonium ion.
     */
    public static final int GLUTAMINE = 6;
    /**
     * Subtype int for a glycine immonium ion.
     */
    public static final int GLYCINE = 7;
    /**
     * Subtype int for an histidine immonium ion.
     */
    public static final int HISTIDINE = 8;
    /**
     * Subtype int for an isoleucine immonium ion.
     */
    public static final int ISOLEUCINE = 9;
    /**
     * Subtype int for a leucine immonium ion.
     */
    public static final int LEUCINE = 10;
    /**
     * Subtype int for a lysine immonium ion.
     */
    public static final int LYSINE = 11;
    /**
     * Subtype int for a methionine immonium ion.
     */
    public static final int METHIONINE = 12;
    /**
     * Subtype int for a phenylananine immonium ion.
     */
    public static final int PHENYLALANINE = 13;
    /**
     * Subtype int for a proline immonium ion.
     */
    public static final int PROLINE = 14;
    /**
     * Subtype int for a selenocysteine immonium ion.
     */
    public static final int SELENOCYSTEINE = 15;
    /**
     * Subtype int for a serine immonium ion.
     */
    public static final int SERINE = 16;
    /**
     * Subtype int for a threonine immonium ion.
     */
    public static final int THREONINE = 17;
    /**
     * Subtype int for a tryptophan immonium ion.
     */
    public static final int TRYPTOPHAN = 18;
    /**
     * Subtype int for a tyrosine immonium ion.
     */
    public static final int TYROSINE = 19;
    /**
     * Subtype int for a valine immonium ion.
     */
    public static final int VALINE = 20;
    /**
     * Subtype of immonium ion.
     */
    private int subType;
    /**
     * The CV term of the reporter ion, null if not set.
     */
    private CvTerm cvTerm = null;
    /**
     * The PSI MS CV term of the reporter ion, null if not set.
     */
    private CvTerm psiCvTerm = null;

    /**
     * Constructor for an immonium ion.
     *
     * @param residue the type of immonium ion as char
     */
    public ImmoniumIon(char residue) {
        type = IonType.IMMONIUM_ION;
        this.subType = getSubtype(residue);
        AminoAcid currentAA = AminoAcid.getAminoAcid(residue);
        theoreticMass1 = currentAA.getMonoisotopicMass() - Atom.C.getMonoisotopicMass() - Atom.O.getMonoisotopicMass();
    }

    /**
     * Constructor for an immonium ion.
     *
     * @param subType the type of immonium ion as integer as indexed by the
     * static fields
     */
    public ImmoniumIon(int subType) {
        type = IonType.IMMONIUM_ION;
        this.subType = subType;
        char aa = getResidue(subType);
        AminoAcid currentAA = AminoAcid.getAminoAcid(aa);
        theoreticMass1 = currentAA.getMonoisotopicMass() - Atom.C.getMonoisotopicMass() - Atom.O.getMonoisotopicMass();
    }

    /**
     * Returns the amino acid of the immonium ion based on the subtype index.
     *
     * @param subtype the subtype index from the static fields
     * @return the one letter code of the amino acid
     */
    public static char getResidue(int subtype) {
        switch (subtype) {
            case ALANINE:
                return 'A';
            case CYSTEINE:
                return 'C';
            case ASPARTIC_ACID:
                return 'D';
            case GLUTAMIC_ACID:
                return 'E';
            case PHENYLALANINE:
                return 'F';
            case GLYCINE:
                return 'G';
            case HISTIDINE:
                return 'H';
            case ISOLEUCINE:
                return 'I';
            case LYSINE:
                return 'K';
            case LEUCINE:
                return 'L';
            case METHIONINE:
                return 'M';
            case ASPARAGINE:
                return 'N';
            case PROLINE:
                return 'P';
            case GLUTAMINE:
                return 'Q';
            case ARGININE:
                return 'R';
            case SERINE:
                return 'S';
            case THREONINE:
                return 'T';
            case VALINE:
                return 'V';
            case TRYPTOPHAN:
                return 'W';
            case TYROSINE:
                return 'Y';
            default:
                return 'X';
        }
    }

    /**
     * Returns the subtype identifier based on the amino acid one letter symbol.
     *
     * @param residue the amino acid as char
     * @return the subtype as indexed by the static fields. -1 if not found.
     */
    public static int getSubtype(char residue) {
        switch (residue) {
            case 'A':
                return ALANINE;
            case 'C':
                return CYSTEINE;
            case 'D':
                return ASPARTIC_ACID;
            case 'E':
                return GLUTAMIC_ACID;
            case 'F':
                return PHENYLALANINE;
            case 'G':
                return GLYCINE;
            case 'H':
                return HISTIDINE;
            case 'I':
                return ISOLEUCINE;
            case 'K':
                return LYSINE;
            case 'L':
                return LEUCINE;
            case 'M':
                return METHIONINE;
            case 'N':
                return ASPARAGINE;
            case 'P':
                return PROLINE;
            case 'Q':
                return GLUTAMINE;
            case 'R':
                return ARGININE;
            case 'S':
                return SERINE;
            case 'T':
                return THREONINE;
            case 'V':
                return VALINE;
            case 'W':
                return TRYPTOPHAN;
            case 'Y':
                return TYROSINE;
            default:
                return -1;
        }
    }

    @Override
    public String getName() {
        return "i" + getResidue(subType);
    }

    @Override
    public CvTerm getPrideCvTerm() {
        // @TODO: replace by MS:1001239? 
        //        will result in issues for the PRIDE XML export 
        //        and also has implications for the mzid export as all immonium ions will 
        //        get the same cv term and this end up being group togeher when iterating 
        //        the terms in the writeSpectrumIdentificationResult method

        if (cvTerm != null) {
            return cvTerm;
        }

        switch (subType) {
            case ALANINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000240", "immonium A", "0");
                break;
            case CYSTEINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000241", "immonium C", "0");
                break;
            case ASPARTIC_ACID:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000242", "immonium D", "0");
                break;
            case GLUTAMIC_ACID:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000243", "immonium E", "0");
                break;
            case PHENYLALANINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000244", "immonium F", "0");
                break;
            case GLYCINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000245", "immonium G", "0");
                break;
            case HISTIDINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000246", "immonium H", "0");
                break;
            case ISOLEUCINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000247", "immonium I", "0");
                break;
            case LYSINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000248", "immonium K", "0");
                break;
            case LEUCINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000249", "immonium L", "0");
                break;
            case METHIONINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000250", "immonium M", "0");
                break;
            case ASPARAGINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000251", "immonium N", "0");
                break;
            case PROLINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000252", "immonium P", "0");
                break;
            case GLUTAMINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000253", "immonium Q", "0");
                break;
            case ARGININE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000254", "immonium R", "0");
                break;
            case SERINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000255", "immonium S", "0");
                break;
            case THREONINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000256", "immonium T", "0");
                break;
            case VALINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000257", "immonium V", "0");
                break;
            case TRYPTOPHAN:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000258", "immonium W", "0");
                break;
            case TYROSINE:
                cvTerm = new CvTerm("PRIDE", "PRIDE:0000259", "immonium Y", "0");
                break;
        }

        return cvTerm;
    }

    @Override
    public CvTerm getPsiMsCvTerm() {
        if (psiCvTerm != null) {
            return psiCvTerm;
        }
        psiCvTerm = new CvTerm("PSI-MS", "MS:1001239", "frag: immonium ion", null);
        return psiCvTerm;
    }

    @Override
    public int getSubType() {
        return subType;
    }

    @Override
    public String getSubTypeAsString() {
        return "Immonium " + getResidue(subType);
    }

    /**
     * Returns an arraylist of possible subtypes.
     *
     * @return an arraylist of possible subtypes
     */
    public static ArrayList<Integer> getPossibleSubtypes() {
        ArrayList<Integer> possibleTypes = new ArrayList<Integer>();
        possibleTypes.add(ALANINE);
        possibleTypes.add(CYSTEINE);
        possibleTypes.add(ASPARTIC_ACID);
        possibleTypes.add(GLUTAMIC_ACID);
        possibleTypes.add(PHENYLALANINE);
        possibleTypes.add(GLYCINE);
        possibleTypes.add(HISTIDINE);
        possibleTypes.add(ISOLEUCINE);
        possibleTypes.add(LYSINE);
        possibleTypes.add(LEUCINE);
        possibleTypes.add(METHIONINE);
        possibleTypes.add(ASPARAGINE);
        possibleTypes.add(PROLINE);
        possibleTypes.add(GLUTAMINE);
        possibleTypes.add(ARGININE);
        possibleTypes.add(SERINE);
        possibleTypes.add(THREONINE);
        possibleTypes.add(VALINE);
        possibleTypes.add(TRYPTOPHAN);
        possibleTypes.add(TYROSINE);
        return possibleTypes;
    }

    @Override
    public NeutralLoss[] getNeutralLosses() {
        return null;
    }

    @Override
    public boolean isSameAs(Ion anotherIon) {
        return anotherIon.getType() == IonType.IMMONIUM_ION
                && anotherIon.getSubType() == subType;
    }
}
