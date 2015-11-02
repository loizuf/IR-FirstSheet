package searchengines;

import java.util.ArrayList;

import indexing.InvertedIndex;
import indexing.Query;

public class BooleanSearchEngine {
	
	public static ArrayList<Integer> performSearch(InvertedIndex invertedIndex, Query query) {
		ArrayList<String> searchResult  = new ArrayList<>();
		ArrayList<String> queryWordList = query.getUniqueWordList();
		ArrayList<Integer> resultPostingsList;
		switch(queryWordList.size()){
		case 0:
			resultPostingsList = new ArrayList<>();
			break;
		case 1:
			String term = queryWordList.get(0);
			resultPostingsList = invertedIndex.searchForSingleWord(term);
			break;
		default:
			String firstTerm = queryWordList.get(0);
			String secondTerm = queryWordList.get(1);
			System.out.println(queryWordList);
			ArrayList<Integer> firstPostingsList = invertedIndex.searchForSingleWord(firstTerm);
			ArrayList<Integer> secondPostingsList = invertedIndex.searchForSingleWord(secondTerm);
			resultPostingsList = performANDMerge(firstPostingsList, secondPostingsList);
			break;
		}
		return resultPostingsList;
	}

	private static ArrayList<Integer> performANDMerge(ArrayList<Integer> firstPostingsList,
		ArrayList<Integer> secondPostingsList) {
		// Setup Variables
		ArrayList<Integer> result = new ArrayList<>();
		int firstIndex = 0, secondIndex = 0;
		int firstSize = firstPostingsList.size(), secondSize = secondPostingsList.size();
		if(firstSize==0 || secondSize==0){
			return result;
		}
		int firstID = firstPostingsList.get(firstIndex);
		int secondID = secondPostingsList.get(secondIndex);

		while (firstIndex < firstSize && secondIndex < secondSize) {
			if (firstID == secondID) {
				result.add(firstID);
				// Advance both lists
				firstIndex++;
				secondIndex++;
				if (firstIndex < firstSize && secondIndex < secondSize) {
					firstID = firstPostingsList.get(firstIndex);
					secondID = secondPostingsList.get(secondIndex);
				} else
					break;
			} else {
				if (firstID < secondID) {
					// Advance first list
					firstIndex++;
					if (firstIndex < firstSize) {
						firstID = firstPostingsList.get(firstIndex);
					} else
						break;
				} else {
					// Advance second List
					secondIndex++;
					if (secondIndex < secondSize) {
						secondID = secondPostingsList.get(secondIndex);
					} else break;
				}
			}
		}
		return result;
	}
}
