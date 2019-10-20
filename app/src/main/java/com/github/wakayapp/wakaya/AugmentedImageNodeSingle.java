package com.github.wakayapp.wakaya;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.MotionEvent;

import com.google.ar.core.AugmentedImage;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.HitTestResult;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.rendering.ModelRenderable;
import java.util.concurrent.CompletableFuture;

/**
 * Node for rendering an augmented image. The image is framed by placing the virtual picture frame
 * at the corners of the augmented image trackable.
 */
@SuppressWarnings({"AndroidApiChecker"})
public class AugmentedImageNodeSingle extends AnchorNode {

    private static final String TAG = "AugmentedImageNodeSingle";
    private static final int TURTLE_ID = R.layout.activity_turtle_info;

    private final Context context;
    private String model_asset;

    // The augmented image represented by this node.
    private AugmentedImage image;

    // Single block to render
    private Node singleNode;

    // Add a variable called singleRenderable for use with loading
    // GreenMaze.sfb.
    private CompletableFuture<ModelRenderable> singleRenderable;

    // Replace the definition of the AugmentedImageNode function with the
    // following code, which loads SeaTurtle.sfb into singleRenderable.
    public AugmentedImageNodeSingle(Context context, String model_asset) {
        this.context = context;
        this.model_asset = model_asset;
        singleRenderable =
                ModelRenderable.builder()
                        .setSource(context, Uri.parse(model_asset))
                        .build();
    }

    // Replace the definition of the setImage function with the following
    // code, which checks if singleRenderable has completed loading.

    public void setImage(AugmentedImage image) {
        this.image = image;

        // Initialize singleNode and set its parents and the Renderable.
        // If any of the models are not loaded, process this function
        // until they all are loaded.
        if (!singleRenderable.isDone()) {
            CompletableFuture.allOf(singleRenderable)
                    .thenAccept((Void aVoid) -> setImage(image))
                    .exceptionally(
                            throwable -> {
                                Log.e(TAG, "Exception loading", throwable);
                                return null;
                            });
            return;
        }

        // Set the anchor based on the center of the image.
        setAnchor(image.createAnchor(image.getCenterPose()));

        singleNode = new Node();
        singleNode.setParent(this);
        singleNode.setRenderable(singleRenderable.getNow(null));

        singleNode.setOnTapListener(
                (HitTestResult hitTestResult, MotionEvent motionEvent) -> {
                    onTap();
                });
    }

    public AugmentedImage getImage() {
        return image;
    }

    public void onTap() {
        if (!this.model_asset.equals("sea_turtle.sfb"))
            return;

        final Intent intent = new Intent(context, AnimalInfoActivity.class);
        intent.putExtra(AnimalInfoActivity.ANIMAL_ACTIVITY_ID, TURTLE_ID);
        context.startActivity(intent);
    }

}
