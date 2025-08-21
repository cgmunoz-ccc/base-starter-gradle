package com.vaadin.starter.skeleton.components;

import java.util.List;

public class BreadcrumbConstants {

    public static final Integer NUMBER_OF_PAGES = 3;

    /*
    Pages ordered according to their position in the breadcrumb
     */

    public static final String PAGE_TITLE_0 = "User Data";
    public static final String PAGE_ROUTE_0 = "calculator";

    public static final String PAGE_TITLE_1 = "Calculator";
    public static final String PAGE_ROUTE_1 = "calculator/start";

    public static final String PAGE_TITLE_2 = "Summary";
    public static final String PAGE_ROUTE_2 = "calculator/summary";

    /*
    Ability to access the previus constants by list
     */

    public static final List<String> PAGE_TITLES = List.of(
        PAGE_TITLE_0,
        PAGE_TITLE_1,
        PAGE_TITLE_2
    );

    public static final List<String> PAGE_ROUTES = List.of(
        PAGE_ROUTE_0,
        PAGE_ROUTE_1,
        PAGE_ROUTE_2
    );
}