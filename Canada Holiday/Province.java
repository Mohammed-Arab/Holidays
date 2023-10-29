/***
 * The Canadian provinces and territories.
 *
 * @author Jason Heard
 */
public enum Province {

    Invalid("Invalid", "NA"),
    Alberta("Alberta", "AB"),
    BritishColumbia("British Columbia", "BC"),
    Manitoba("Manitoba", "MB"),
    NewBrunswick("New Brunswick", "NB`"),
    NewfoundlandLabrador("Newfoundland and Labrador", "NL"),
    NorthwestTerritories("Northwest Territories", "NT"),
    NovaScotia("Nova Scotia", "NS"),
    Nunavut("Nunavut", "NU"),
    Ontario("Ontario", "ON"),
    PrinceEdwardIsland("Prince Edward Island", "PE"),
    Quebec("Quebec", "QC"),
    Saskatchewan("Saskatchewan", "SK"),
    Yukon("Yukon", "YT");

    /***
     * Attempts to parse the given postal abbreviation into a province.
     *
     * @param postalProvince
     *            The postal abbreviation to attempt to lookup.
     *
     * @return The matching province or <code>Province.Invalid</code> if the
     *         given abbreviation does not match any provinces.
     */
    public static Province getProvinceFromPostal(String postalProvince) {
        for (Province possibleProvince : Province.values()) {
            if (possibleProvince.code.equalsIgnoreCase(postalProvince)) {
                return possibleProvince;
            }
        }

        return Province.Invalid;
    }

    Province(String name, String code) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return name;
    }

    private final String code;
    private final String name;

}
