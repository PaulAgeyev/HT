class Type implements Rooms {

    private int Economy_1 = 0;
    private int Economy_2 = 0;
    private int Economy_3 = 0;

    private int Standard_1 = 0;
    private int Standard_2 = 0;
    private int Standard_3 = 0;

    private int Business_1 = 0;
    private int Business_2 = 0;
    private int Business_3 = 0;

    private int Suite_1 = 0;
    private int Suite_2 = 0;
    private int Suite_3 = 0;


    void makeInsert(Request ob) {
        if (ob.getTypeofRoom() == "Economy") {
            if (Economy_1 < ECONOMY_ONE_ROOM && (ob.getPlaces() == 1))
                Economy_1++;
            if (Economy_2 < ECONOMY_TWO_ROOM && (ob.getPlaces() == 2))
                Economy_2++;
            if (Economy_3 < ECONOMY_THREE_ROOM && (ob.getPlaces() == 3))
                Economy_3++;
        }
        else
        if (ob.getTypeofRoom() == "Standard") {
            if (Standard_1 < STANDARD_ONE_ROOM && (ob.getPlaces() == 1))
                Standard_1++;
            if (Standard_2 < STANDARD_TWO_ROOM && (ob.getPlaces() == 2))
                Standard_2++;
            if (Standard_3 < STANDARD_THREE_ROOM && (ob.getPlaces() == 3))
                Standard_3++;
        }
        else
        if (ob.getTypeofRoom() == "Business") {
            if (Business_1 < BUSINESS_ONE_ROOM && (ob.getPlaces() == 1))
                Business_1++;
            if (Business_2 < BUSINESS_TWO_ROOM && (ob.getPlaces() == 2))
                Business_2++;
            if (Business_3 < BUSINESS_THREE_ROOM && (ob.getPlaces() == 3))
                Business_3++;
        }
        else
        if (ob.getTypeofRoom() == "Suite") {
            if (Suite_1 < SUITE_ONE_ROOM && (ob.getPlaces() == 1))
                Suite_1++;
            if (Suite_2 < SUITE_TWO_ROOM && (ob.getPlaces() == 2))
                Suite_2++;
            if (Suite_3 < SUITE_THREE_ROOM && (ob.getPlaces() == 3))
                Suite_3++;
        }
    }
    void makeDelete(Request ob) {
        if (ob.getTypeofRoom() == "Economy") {
            if (ob.getPlaces() == 1)
                Economy_1--;
            if (ob.getPlaces() == 2)
                Economy_2--;
            if (ob.getPlaces() == 3)
                Economy_3--;
        }
        else
        if (ob.getTypeofRoom() == "Standard") {
            if (ob.getPlaces() == 1)
                Standard_1--;
            if (ob.getPlaces() == 2)
                Standard_2--;
            if (ob.getPlaces() == 3)
                Standard_3--;
        }
        else
        if (ob.getTypeofRoom() == "Business") {
            if (ob.getPlaces() == 1)
                Business_1--;
            if (ob.getPlaces() == 2)
                Business_2--;
            if (ob.getPlaces() == 3)
                Business_3--;
        }
        else
        if (ob.getTypeofRoom() == "Suite") {
            if (ob.getPlaces() == 1)
                Suite_1--;
            if (ob.getPlaces() == 2)
                Suite_2--;
            if (ob.getPlaces() == 3)
                Suite_3--;
        }
    }
    boolean Sort(Request ob) {
        if (ob.getTypeofRoom() == "Economy")
            return SortEconomy(ob);
        if (ob.getTypeofRoom() == "Standard")
           return SortStandard(ob);
        if (ob.getTypeofRoom() == "Business")
            return SortBusiness(ob);
        if (ob.getTypeofRoom() == "Suite")
           return SortSuite(ob);
        else
            return false;
    }
    boolean SortEconomy(Request ob) {
        if ( (ob.getTypeofRoom() == "Economy") & (ob.getPlaces() == 1) & (Economy_1 < ECONOMY_ONE_ROOM) )
            return true;
        if ( (ob.getTypeofRoom() == "Economy") & (ob.getPlaces() == 2) & (Economy_2 < ECONOMY_TWO_ROOM) )
            return true;
        if ( (ob.getTypeofRoom() == "Economy") & (ob.getPlaces() == 3) & (Economy_3 <ECONOMY_THREE_ROOM) )
            return true;
        else
            return false;
    }
    boolean SortStandard(Request ob) {
        if ( (ob.getTypeofRoom() == "Standard") & (ob.getPlaces() == 1) & (Standard_1 < STANDARD_ONE_ROOM) )
            return true;
        if ( (ob.getTypeofRoom() == "Standard") & (ob.getPlaces() == 2) & (Standard_2 < STANDARD_TWO_ROOM) )
            return true;
        if ( (ob.getTypeofRoom() == "Standard") & (ob.getPlaces() == 3) & (Standard_3 < STANDARD_THREE_ROOM) )
            return true;
        else
            return false;
    }
    boolean SortBusiness(Request ob) {
        if ( (ob.getTypeofRoom() == "Business") & (ob.getPlaces() == 1) & (Business_1 < BUSINESS_ONE_ROOM) )
            return true;
        if ( (ob.getTypeofRoom() == "Business") & (ob.getPlaces() == 2) & (Business_2 < BUSINESS_TWO_ROOM) )
            return true;
        if ( (ob.getTypeofRoom() == "Business") & (ob.getPlaces() == 3) & (Business_3 < BUSINESS_THREE_ROOM) )
            return true;
        else
            return false;
    }
    boolean SortSuite(Request ob) {
        if ((ob.getTypeofRoom() == "Suite") & (ob.getPlaces() == 1) & (Suite_1 < SUITE_ONE_ROOM))
            return true;
        if ((ob.getTypeofRoom() == "Suite") & (ob.getPlaces() == 2) & (Suite_2 < SUITE_TWO_ROOM))
            return true;
        if ((ob.getTypeofRoom() == "Suite") & (ob.getPlaces() == 3) & (Suite_3 < SUITE_THREE_ROOM))
            return true;
        else
            return false;
    }
}