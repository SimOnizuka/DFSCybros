package it.uniba.dib.mfs.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class ApiController {
	private List<String> ratings = new ArrayList<>();

	public int grammarcheck(String bodySourceString) {
	
		//non può effettuare una query con stringa maggiore di 100 caratteri
		if(bodySourceString.length() >= 100) {
			bodySourceString = bodySourceString.substring(0, 100);
		}
		
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.textgears.com/grammar";
        String text = bodySourceString;
        String requestJson = "{\"key\": \"kAju4tuYWvUG0Qar\",\"text\": \""+text+"\",\"language\": \"it-IT\"}";
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);

        String answer = restTemplate.postForObject(url, entity, String.class);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode responseJson = objectMapper.readTree(answer);
           
            JsonNode errorsArray = responseJson.get("response").get("errors");
            int totalErrors = errorsArray.size();
            
            return totalErrors;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
      
        return -1;

    }

	public List<String> googleFactCheck(String titleNews) {
		
        RestTemplate restTemplate = new RestTemplate();
        
        String query = titleNews;
       
      //non può effettuare una query con stringa maggiore di 70 caratteri
        if (query.length() >= 70) {
        	query = query.substring(0,70);
        }
        
        String url = "https://factchecktools.googleapis.com/v1alpha1/claims:search?query="+query+"&key=AIzaSyBtxVOvQ5TpAlYN9tA_gSHDQSmWgyuHKS8";
            
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String answer = restTemplate.getForObject(url, String.class);
        
        if(answer.trim().equals("{}")){ 
            System.out.println("return null");
            ratings = new ArrayList<>(); //svuoto la lista
            return ratings;
        
        }
        //else
        findRatingsList(answer);

        return ratings;

    }
	
	private void findRatingsList(String answerString){
		
		try {
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode claimReviewJson = mapper.readTree(answerString).get("claims");
	        
	        
	        for (JsonNode claim : claimReviewJson) {
	            JsonNode claimReview = claim.get("claimReview");
	            if (claimReview.isArray()) {
	                for (JsonNode review : claimReview) {
	                    JsonNode textualRatingNode = review.get("textualRating");
	                    if (textualRatingNode != null) {
	                        String textualRating = textualRatingNode.asText();
	                        ratings.add(textualRating);
	                    }
	                }
	            }
	        }
	        
	        // Stampa dei textualRating
	        for (String rating : ratings) {
	            System.out.println(rating);//DA TOGLIERE
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
       
	}
}