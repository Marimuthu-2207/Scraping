package scrapingProj;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;


public class WebScraping {

	public WebScraping() {
		Document document = null;

		try {
			document = Jsoup.connect("https://www.tripadvisor.in/Hotel_Review-g194710-d616414-Reviews-Centro_Vacanze_Pra_delle_Torri-Caorle_Veneto.html").get();
			
			//Elements block = document.select("div.hotels-community-tab-common-Card__card--ihfZB hotels-community-tab-common-Card__section--4r93H");
			Elements overallRating= document.select("div#ABOUT_TAB");
			Elements overallRatingDisplay=overallRating.select("div.hotels-hotel-review-about-with-photos-Reviews__rating--2X_zZ span");
			Element totalReviews= document.select("div.hotels-hotel-review-atf-info-parts-ATFInfo__ratingContainer--1WtGm a").first(); //sabse uparwala
			
			System.out.println("\n\t Title: "+(String)document.title());
			System.out.println("\n\t\t Total reviews: "+totalReviews.text());
			System.out.println("\n\t\t Overall rating: "+overallRatingDisplay.first().text());

			Elements name = document.select("div.social-member-event-MemberEventOnObjectBlock__event_type--3njyv a");
			Elements reviews= document.select("div.cPQsENeY span");
			Elements reviewTitle = document.select("div.hotels-review-list-parts-ReviewTitle__reviewTitle--2Fauz span");
			Elements dateOfStay = document.select("span.hotels-review-list-parts-EventDate__event_date--CRXs4");
			
			//Elements dateOfPosting = document.select("div.social-member-event-MemberEventOnObjectBlock__event_type--3njyv");
		//	System.out.println("********"+dateOfPosting.text());
			
			for(int i=0, j=1;i<reviews.size();i++,j++) {
				System.out.println("\n\t"+j+". Review Title: "+reviewTitle.get(i).text());
				
				System.out.println("\n\t Posted by: "+name.get(i).text());
				
				System.out.println("\n\t "+dateOfStay.get(i).text());
				
				System.out.println("\n\t Review: "+reviews.get(i).text());
			}
			System.out.println("\n\t ----------------------END----------------------");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new WebScraping();

	}

}
