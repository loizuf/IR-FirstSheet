package indexing;

import java.util.List;

public interface Index {
	float getIDF(String paramString);

	int getTF(String paramString, Indexable paramIndexable);

	int getDF(String paramString);

	List<Indexable> getDocumentList(String paramString);
}
