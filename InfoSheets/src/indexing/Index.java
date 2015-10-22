package indexing;

import java.util.List;

public interface Index {
	public abstract float getIDF(String paramString);

	public abstract int getTF(String paramString, Indexable paramIndexable);

	public abstract int getDF(String paramString);

	public abstract List<Indexable> getDocumentList(String paramString);
}
