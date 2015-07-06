package br.com.bitwaysystem;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Based in
 * http://mongodb.github.io/mongo-java-driver/3.0/driver/getting-started/quick-
 * tour/
 * http://mongodb.github.io/mongo-java-driver/3.0/driver/getting-started/quick-
 * tour-admin/
 * http://mongodb.github.io/mongo-java-driver/3.0/driver/reference/crud/
 * 
 * @author fspoliveira
 *
 */

public class Main {

	public static void main(String[] args) {
				
		MongoClient mongoClient = new MongoClient("localhost");

		MongoDatabase database = mongoClient.getDatabase("mydb");

		// Insert a Document
		MongoCollection<Document> collection = database.getCollection("test");

		Document doc = new Document("name", "MongoDB").append("type", "database").append("count", 1).append("info",
				new Document("x", 203).append("y", 102));

		collection.insertOne(doc);

		// Find first
		Document myDoc = collection.find().first();
		System.out.println(myDoc.toJson());

		// Find All Documents in a Collection
		for (Document cur : collection.find()) {
			System.out.println(cur.toJson());
		}

		// Get A List of Databases
		for (String name : mongoClient.listDatabaseNames()) {
			System.out.println(name);
		}

		// Get A List of Collections
		for (String name : database.listCollectionNames()) {
			System.out.println(name);
		}
		mongoClient.close();
	}
}
