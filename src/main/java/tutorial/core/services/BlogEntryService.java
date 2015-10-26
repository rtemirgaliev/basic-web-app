package tutorial.core.services;

import tutorial.core.models.entities.BlogEntry;

public interface BlogEntryService {

    public BlogEntry findBlogEntry (Long id);
    public BlogEntry deleteBlogEntry (Long id);

    /**
     * @param id the id of the BlogEntry to update
     * @param data the BlogEntry containing the data to be used for the update
     * @return the updated BlogEntry or null if the BlogEntry with the id cannot be found
     */
    public BlogEntry updateBlogEntry(Long id, BlogEntry data);

}
