package it.uniba.dib.mfs.controller;

import java.net.URI;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebScrapingController {

	public static String sourceWebScraping(String link) {
		
		 try {
		        // Effettua la connessione e ottieni il documento HTML
		        Document doc = Jsoup.connect(link).get();

		        // Seleziona il tag <meta> con l'attributo "property" contenente il valore "og:site_name"
		        Element siteNameElement = doc.select("meta[property=og:site_name]").first();

		        // Estrai l'autore dalla proprietà "content" dell'elemento <meta>
		        String author = siteNameElement != null ? siteNameElement.attr("content") : "";
		        
		        // Se il nome del sito è vuoto, estrai il nome del sito dall'URL
		        if (author.isEmpty()) {
		            URI uri = new URI(link);
		            String host = uri.getHost();
		            author = host != null ? host.replaceFirst("www\\.", "") : "";
		        }

		        return author;
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return null;
	
	}
	
	public static String dataWebScraping(String link) {
		
		 try {
		        // Effettua la connessione e ottieni il documento HTML
		        Document doc = Jsoup.connect(link).get();

		        // Cerca l'elemento <time> che contiene la data di pubblicazione
		        Element timeElement = doc.select("time").first();

		        if (timeElement != null) {
		            // Se l'elemento <time> viene trovato, estrai la data di pubblicazione
		            return timeElement.text();
		        } else {
		            // Cerca l'elemento <span> con la classe "date" che contiene la data di pubblicazione alternativa
		            Element dateElement = doc.selectFirst("span.date");

		            if (dateElement != null) {
		                // Se l'elemento <span> viene trovato, estrai la data di pubblicazione
		                return dateElement.text();
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return null;
	}
	
	public static String titleWebScraping(String link) {

		try {
			// Effettua la connessione e ottieni il documento HTML
            Document doc = Jsoup.connect(link).get();

            // Trova l'elemento HTML del titolo
            Element titleElement = doc.selectFirst("h1");

            // Estrai il testo del titolo
            String title = titleElement.text();

            
            return title;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String bodyWebScraping(String link) {
		
		  try {
		        // Effettua la connessione e ottieni il documento HTML
		        Document doc = Jsoup.connect(link).get();

		        // Trova l'elemento HTML che contiene il contenuto dell'articolo
		        Element articleElement = doc.selectFirst("article");

		        // Se l'elemento "article" non viene trovato, cerca il selettore "div.main-content"
		        if (articleElement == null) {
		            articleElement = doc.selectFirst("div.main-content");
		        }

		        if (articleElement != null) {
		            // Estrai il testo dell'articolo
		            String articleContent = articleElement.text();

		            // Stampa il contenuto dell'articolo
		            //System.out.println("webscraping:" + articleContent);
		            
		            if(articleContent.length() >= 200) {
		            	articleContent = articleContent.substring(0, 200);
		    		}
		            
		            return articleContent;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		
		return null;
	}
}