package com.example.claudiabee.listentoastory;

public class Fable {


    /**
     * Title of the fable.
     */
    private String mFableTitle;
    /**
     * Name of the reader of the fable.
     */
    private String mReaderName;
    /**
     * Title of the book.
     */
    private String mBookTitle;
    /**
     * Audio file resource ID for the fable
     */
    private int mAudioResourceId;
    private String mAudioDuration;

    /**
     * Create a {@link Fable} object
     *
     * @param fableTitle      is the title of the fable
     * @param readerName      is the reader's name
     * @param bookTitle       is the title of the book
     * @param audioResourceId is the resource ID of the fable audio file
     * @param audioDuration   is the duration of the audio file
     */
    public Fable(String fableTitle, String readerName, String bookTitle, int audioResourceId, String audioDuration) {
        mFableTitle = fableTitle;
        mReaderName = readerName;
        mBookTitle = bookTitle;
        mAudioResourceId = audioResourceId;
        mAudioDuration = audioDuration;

    }

    /**
     * Return the title of the fable
     */
    public String getFableTitle() {
        return mFableTitle;
    }

    /**
     * Return the reader's name of the fable
     */
    public String getReaderName() {
        return mReaderName;
    }

    /**
     * Return the title of the book
     */
    public String getBookTitle() {
        return mBookTitle;
    }

    /**
     * Return the resource ID for the audio file
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    public String getAudioDuration() {
        return mAudioDuration;
    }

    /**
     * Returns the string representation of the {@link Fable} object.
     */
    @Override
    public String toString() {
        return "Fable{" +
                "mFableTitle='" + mFableTitle + '\'' +
                ", mReaderName='" + mReaderName + '\'' +
                ", mBookTitle=" + mBookTitle +
                ", mAudioDuration=" + mAudioDuration +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
